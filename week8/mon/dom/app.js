console.log("i am printed by javascript file");

const h1 = document.querySelector("h1");
h1.innerText = " YAY it is's Monday";
h1.style.color = "red";

const div = document.querySelector("#demo-div");

const p1 = document.createElement("p");
p1.innerText = "I'm the first paragraph";

const p2 = document.createElement("p");
p2.innerText = "I'm the second paragraph";


const p3 = document.createElement("p");
p3.innerText = "I'm the third paragraph";

div.appendChild(p1);
div.appendChild(p2);
div.appendChild(p3);



const paragraph = document.querySelectorAll("p");
console.log(paragraph);

// Can treat node list the same as a JS array
// (Better to use CSS for changing color style, e.g. .add("blue-text") as per below)

const makeTextBlue= function(){
    for (let i = 0; i < paragraph.length; i++) {
        // paragraph[i].style.color="blue";
        paragraph[i].classList.add("blue-text");

}}

const textChanger = document.querySelector("#text-changer");
textChanger.addEventListener("click",makeTextBlue);


