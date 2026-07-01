// Register User
async function registerUser() {

    const user = {

        name: document.getElementById("regName").value,
        email: document.getElementById("regEmail").value,
        password: document.getElementById("regPassword").value

    };

    const response = await fetch(BASE_URL + "/auth/register", {

        method: "POST",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify(user)

    });

    const data = await response.json();

    document.getElementById("registerMessage").innerHTML = data.message;

}



// Login User
async function loginUser() {

    const user = {

        email: document.getElementById("loginEmail").value,
        password: document.getElementById("loginPassword").value

    };

    const response = await fetch(BASE_URL + "/auth/login", {

        method: "POST",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify(user)

    });

    const data = await response.json();

    if (data.token) {

        localStorage.setItem("token", data.token);

        document.getElementById("dashboard").classList.remove("hidden");

        document.getElementById("loginMessage").innerHTML =
                "Login Successful";

        loadEvents();

    } else {

        document.getElementById("loginMessage").innerHTML =
                "Invalid Credentials";

    }

}



// Logout
function logout() {

    localStorage.removeItem("token");

    location.reload();

}