function getUpdate(clickCheckbox) {
    if (clickCheckbox.checked) {
        document.getElementById("receiver").disabled = false;
    } else {
        document.getElementById("receiver").disabled = true;
    }
}