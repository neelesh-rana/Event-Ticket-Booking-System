window.onload = function () {

    const token = localStorage.getItem("token");

    if (token != null) {

        document.getElementById("dashboard").classList.remove("hidden");

        loadEvents();

    }

}