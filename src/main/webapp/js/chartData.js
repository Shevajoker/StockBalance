/**
 * 
 */
var table = document.getElementsByClassName('table');
console.log(table);
console.log(table[0].rows[1].cells[1].textContent);
console.log(table[0].rows.length);
rowsCount = table[0].rows.length;

let labelsData = new Array();
let dataData = new Array();
var labelData = table[0].rows[1].cells[1].textContent;

    for(i = 1; i < table[0].rows.length; i++){
    	labelsData[i-1] = table[0].rows[i].cells[2].textContent;
    	dataData[i-1] = table[0].rows[i].cells[3].textContent;
    }
    console.log(labelsData);
    console.log(dataData);