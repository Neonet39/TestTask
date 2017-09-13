function validate(){

    valid = true;
    var tableElem = document.getElementById('age-table');
    var elements = tableElem.getElementsByTagName('input');

    var sum = 0;
    for (var i = 0; i < elements.length; i++) {
        if(elements[i].value==""){
            sum++;
        }
        if (!elements[i].value.match(/^\d+$/)&&!elements[i].value=="")
        {

            elements[i].style.borderColor = 'red';
            alert('Only numbers must be in the field!');

            valid=false;

        }
    }
        if(sum==elements.length )
        {
            alert('Fill in at least one field!');
            valid = false;
        }
    return valid;


}
function validateAdrres(){
    valid = true;

    var tableElem = document.getElementById('age-table');
    var elements = tableElem.getElementsByTagName('input');

    for (var i = 0; i < elements.length; i++) {

        if (elements[i].value=="")
        {

            elements[i].style.borderColor = 'red';
            alert('В поле   должны стоять только цыфры!');

            valid=false;

        }
    }
    return valid;
}