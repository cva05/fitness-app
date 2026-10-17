async function calculateCalories() {

    const request = {

        age: Number(
            document.getElementById("age").value
        ),

        gender:
            document.getElementById("gender").value,

        height: Number(
            document.getElementById("height").value
        ),

        weight: Number(
            document.getElementById("weight").value
        ),

        activityLevel:
            document.getElementById("activityLevel").value,

        goal:
            document.getElementById("goal").value
    };


    try {

        const response = await fetch(
            "/api/calorie/calculate",
            {
                method: "POST",

                headers: {
                    "Content-Type":
                        "application/json"
                },

                body:
                    JSON.stringify(request)
            }
        );


        if (!response.ok) {

            alert(
                "Please enter valid information."
            );

            return;
        }


        const result =
            await response.json();


        document.getElementById("bmr")
            .innerText =
            result.bmr + " kcal";


        document.getElementById("maintenance")
            .innerText =
            result.maintenanceCalories
            + " kcal";


        document.getElementById("target")
            .innerText =
            result.targetCalories
            + " kcal";


        document.getElementById("bmi")
            .innerText =
            result.bmi;


        document.getElementById("protein")
            .innerText =
            result.protein + " g";


    } catch (error) {

        console.error(error);

        alert(
            "Unable to connect to server."
        );
    }
}


/* FOOD SEARCH */

async function searchFood() {

    const searchText =
        document
            .getElementById("foodSearch")
            .value
            .trim();


    if (!searchText) {

        alert("Please enter a food name.");

        return;
    }


    try {

        const response =
            await fetch(
                `/api/foods/search?name=${encodeURIComponent(searchText)}`
            );


        if (!response.ok) {

            throw new Error(
                "Unable to search food"
            );
        }


        const foods =
            await response.json();


        displayFoodResults(foods);


    } catch (error) {

        console.error(error);

        alert(
            "Unable to search food."
        );
    }
}


/* DISPLAY SEARCH RESULTS */

function displayFoodResults(foods) {

    const container =
        document.getElementById(
            "foodResults"
        );


    container.innerHTML = "";


    if (foods.length === 0) {

        container.innerHTML =
            `<p class="empty-message">
                No food found.
             </p>`;

        return;
    }


    foods.forEach(food => {

        const div =
            document.createElement("div");


        div.className =
            "food-result";


        div.innerHTML = `

            <strong>
                ${food.name}
            </strong>

            <span>
                ${food.calories} kcal
                ·
                ${food.protein}g protein
                per ${food.servingSize}g
            </span>
        `;


        div.onclick = function () {

            selectFood(food);

        };


        container.appendChild(div);

    });
}


/* SELECT FOOD */

function selectFood(food) {

    const container =
        document.getElementById(
            "selectedFood"
        );


    container.innerHTML = `

        <div class="food-info">

            <h4>
                ${food.name}
            </h4>

            <p>
                Nutritional values
                per ${food.servingSize}g
            </p>

            <div class="food-stats">

                <div class="food-stat">

                    <span>
                        Calories
                    </span>

                    <strong>
                        ${food.calories} kcal
                    </strong>

                </div>


                <div class="food-stat">

                    <span>
                        Protein
                    </span>

                    <strong>
                        ${food.protein} g
                    </strong>

                </div>


                <div class="food-stat">

                    <span>
                        Carbohydrates
                    </span>

                    <strong>
                        ${food.carbohydrates} g
                    </strong>

                </div>


                <div class="food-stat">

                    <span>
                        Fat
                    </span>

                    <strong>
                        ${food.fat} g
                    </strong>

                </div>

            </div>

        </div>
    `;
}