document.querySelector(".scheduler").addEventListener("click", function() {
    document.querySelector(".popup-login").classList.add("active");
});
document.querySelector("..popup-login .close-btn").addEventListener("click", function() {
    document.querySelector(".popup-login").classList.remove("active");
});