darkModeButton = document.getElementById("dark-mode-button")

handleButtonClick = function () {
    console.log("button clicked")
    // change the background colour and text
    body = document.body
    body.style.backgroundColor = "#091d1e"
    body.style.color = "#aaaaaa"

    // change the border of the title

    title = document.getElementById("title-section")
    title.style.border = "1px solid #aaaaaa"

    // change the border and headings on the posts

    posts = document.getElementsByClassName("post")
    for (post of posts) {
        post.style.border = "1px solid #aaaaaa"
    }

    postHeadings = document.getElementsByTagName("h3")
    for (heading of postHeadings) {
        heading.style.color = "#466876"
    }
}

darkModeButton.addEventListener("click", handleButtonClick)


//create new posts with form

const form = document.getElementById('newPost');
form.addEventListener('submit',(event)=>{
    //stop from submission
    event.preventDefault();

    const container = document.querySelector('#post-container');
    const post = document.createElement('section');
    post.classList=document.createElement('h3');


    const postTitle = document.createElement('h3');
    postTitle.innerText=form.elements['postTitle'].value;

    post.appendChild(postTitle);

    const favoriteStar = document.createElement('i');
    favoriteStar.classList.add('fa-star');
    favoriteStar.classList.add('fa-regular');
    addStarToggle(favoriteStar);
    post.appendChild(favoriteStar);

    const postDate = document.createElement('h4');
    postDate.innerText=`Date:${form.elements['postDate'].value}`
    post.appendChild(postDate);

    const postText = document.createElement('p');
    postText.innerText=form.elements['postText'].value;
    post.appendChild(postText);

    container.appendChild(post);

    form.elements['postTitle'].value="";
    form.elements['postDate'].value="";
    form.elements['postText'].value="";



});


//start toggle

const starIconList= document.getElementsByClassName("fa-star");

const addStarToggle = function(starIcon){
    starIcon.addEventListener('click',()=>{
        console.log("clicked on star");
        starIcon.classList.toggle("fa-regular");
        starIcon.classList.toggle("fa-solid");
    })
}

for (let i = 0; i < starIconList.length; i++) {
    addStarToggle(starIconList[i]);
    
}

