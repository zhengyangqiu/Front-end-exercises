// import classes 
// const { Player } = require("./player");

function playWin() {
    var audio = new Audio('./win.mp3');
    audio.play();
  }

  function playDraw() {
    var audio = new Audio('./fail.mp3');
    audio.play();
  }

  
let person = prompt("Please enter your name");

var x = document.getElementById("player1");
x.querySelector("h2").innerHTML = person;

// Player constructor
const Player = function(name, icon, score){
    this.name = name,
    this.icon = icon,
    this.score = 0
}



// event listener for player option
const playerChoice = document.querySelector("#person")
const aiChoice = document.querySelector("#ai")

let player2 = new Player;

// create new player object
const player1 = new Player('Player 1', "X");

const createPlayer2person = () => {
    player2.name = 'Player 2';
    player2.icon = "O";
}
const createPlayer2AI = () => {
    player2.name = 'Super AI';
    player2.icon = 'O';
}
playerChoice.addEventListener('click', createPlayer2person)
aiChoice.addEventListener('click', createPlayer2AI)



// turn counter
let turnCounter = 0;

// has game ended?
let gameOver = false;



// current player
let currentPlayer = player1

// change player function
const changePlayer = (player) => {
    console.log(turnCounter);
    if (player === player1 && player2.name === 'Super AI'){
        currentPlayer = player2;
        playerAITurn();
    } else if (player === player1){
        currentPlayer = player2;
    } else if (player === player2){
        currentPlayer = player1;
    }
}

// AI FUNCTIONS:

// AI player turn
const playerAITurn = () => {
    if (gameOver === false){
        let isEmpty = false;
        let chosenBox;
        // repeat till picks box that is empty
        while (isEmpty === false) {
            // get random box
            chosenBox = randomBox();
            // check if box empty
            isEmpty = checkBoxEmpty(chosenBox);
        }
        
        // add icon to chosen box
        chosenBox.classList.add('purple');
        setTimeout(function(){chosenBox.innerText = altSymbol(currentPlayer); checkGameWon(); changePlayer(currentPlayer);}, 800);
        // chosenBox.innerText = altSymbol(currentPlayer);
        // do end turn checks
        turnCounter++;
    }
      
}
// return random box 1-9
const randomBox = () => {
    const boxNum = Math.floor((Math.random() * 9)+1);
    if (boxNum === 1){
        return boxTopLeft;
    } else if (boxNum === 2){
        return boxTopMid;
    } else if (boxNum === 3){
        return boxTopRight;
    } else if (boxNum === 4){
        return boxMidLeft;
    } else if (boxNum === 5){
        return boxMidMid;
    } else if (boxNum === 6){
        return boxMidRight;
    } else if (boxNum === 7){
        return boxBottomLeft;
    } else if (boxNum === 8){
        return boxBottomMid;
    } else if (boxNum === 9){
        return boxBottomRight;
    } else {console.log("problem here");}

}


// update score function
const updateScore = (player) => {
    if (player === player1){
        document.querySelector("#player1Score").innerText = ("Score: " + player1.score);
    } else if (player === player2){
        document.querySelector("#player2Score").innerText = ("Score: " + player2.score);
    }
    
}


// alternate output depending on player
const altSymbol = (player) => {
    if (player.name === 'Player 1'){
        return 'X';
    } else if (player.name === 'Player 2' || player.name === 'Super AI'){
        return 'O';
    } else {
        console.log("Error with determining player number");
    }
}

// check if box is empty before adding icon
const checkBoxEmpty = (box) => {
    if (box.innerText === ''){
        return true;
    } else {
        return false;
    }
}

//dynamically find the id of cell clicked
function findCurrentResult(event) { 
    return document.getElementById(event.target.id);
  }

  //popup
//   function pop() {
//     var popup = document.getElementById("myPopup");
//     popup.classList.toggle("show");
//   }

  //variables for each cell
  const boxTopLeft = document.querySelector("#top-left");
  const boxTopMid = document.querySelector("#top-mid");
  const boxTopRight = document.querySelector("#top-right");
  const boxMidLeft = document.querySelector("#mid-left");
  const boxMidMid = document.querySelector("#mid-mid");
  const boxMidRight = document.querySelector("#mid-right");
  const boxBottomLeft = document.querySelector("#bottom-left");
  const boxBottomMid = document.querySelector("#bottom-mid");
  const boxBottomRight = document.querySelector("#bottom-right");


  //corresponding event listeners. 
  boxTopLeft.addEventListener('click', clickAnyBox);
  boxTopMid.addEventListener('click', clickAnyBox);
  boxTopRight.addEventListener('click', clickAnyBox);
  boxMidLeft.addEventListener('click', clickAnyBox);
  boxMidMid.addEventListener('click', clickAnyBox);
  boxMidRight.addEventListener('click', clickAnyBox);
  boxBottomLeft.addEventListener('click', clickAnyBox);
  boxBottomMid.addEventListener('click', clickAnyBox);
  boxBottomRight.addEventListener('click', clickAnyBox);

  //function to dynamically click any box:
  //maybe create an object for the different cells and give prototype?
  function clickAnyBox(event) {
    if (gameOver === false){
    if (checkBoxEmpty(findCurrentResult(event))){
    ++turnCounter;
    if(currentPlayer.name === 'Player 1') {
        findCurrentResult(event).classList.add('blue');
    } else if (currentPlayer.name === 'Player 2'){
        findCurrentResult(event).classList.add('purple');
    }
    // console.log(findCurrentResult(event))
    findCurrentResult(event).innerText = altSymbol(currentPlayer);
    checkGameWon();
    changePlayer(currentPlayer);
    }
}
}


// check if game won
const checkGameWon = () => {
    if (gameWon(currentPlayer)){
        // wait for icon to be added to grid before alert message
        playWin(); 
        setTimeout(function(){ changePlayer(currentPlayer);alert (currentPlayer.name + ' has won!'); currentPlayer.score +=1; updateScore(currentPlayer); }, 50);
        gameOver = true;
    } else if (gameDraw()) {
        // if all tiles filled and no winner, say it's a draw
        playDraw();
        setTimeout(function(){ alert ("It's a draw!")}, 50);
        gameOver = true;
    }
}




// Clear Grid

        // locate reset button section
        const resetButton = document.querySelector("#reset-button");
        // create function that changes all inner text of divs to ' '
        const clearDivs = (event) => {
            boxTopLeft.innerText = '';
            boxTopMid.innerText = '';
            boxTopRight.innerText = '';
            boxMidLeft.innerText = '';
            boxMidMid.innerText = '';
            boxMidRight.innerText = '';
            boxBottomLeft.innerText = '';
            boxBottomMid.innerText = '';
            boxBottomRight.innerText = '';
            
            // findCurrentResult(event).classList.remove('blue', 'purple')

            boxTopLeft.classList.remove('blue', 'purple')
            boxTopMid.classList.remove('blue', 'purple')
            boxTopRight.classList.remove('blue', 'purple')
            boxMidLeft.classList.remove('blue', 'purple')
            boxMidMid.classList.remove('blue', 'purple')
            boxMidRight.classList.remove('blue', 'purple')
            boxBottomRight.classList.remove('blue', 'purple')
            boxBottomLeft.classList.remove('blue', 'purple')
            boxBottomMid.classList.remove('blue', 'purple')

    
            gameOver = false;
            turnCounter = 0;
            changePlayer(currentPlayer);
        }
        // create event listener for clicking on reset-button -> run clearDivs function
        resetButton.addEventListener('click', clearDivs);

// Check if game won
        // will take player number as argument
        function gameWon (player) {
            // top row
            if (boxTopLeft.innerText === player.icon && boxTopMid.innerText === player.icon && boxTopRight.innerText === player.icon) {
                console.log(player.name + ' has won');
                return true;
                // mid row
            } else if (boxMidLeft.innerText === player.icon && boxMidMid.innerText === player.icon && boxMidRight.innerText === player.icon) {
                console.log(player.name + ' has won');
                return true;
                // bottom row
            } else if (boxBottomLeft.innerText === player.icon && boxBottomMid.innerText === player.icon && boxBottomRight.innerText === player.icon) {
                console.log(player.name + ' has won');
                return true;
                // left column
            } else if (boxTopLeft.innerText === player.icon && boxMidLeft.innerText === player.icon && boxBottomLeft.innerText === player.icon) {
                console.log(player.name + ' has won');
                return true;
                // mid column
            } else if (boxTopMid.innerText === player.icon && boxMidMid.innerText === player.icon && boxBottomMid.innerText === player.icon) {
                console.log(player.name + ' has won');
                return true;
                // right column
            } else if (boxTopRight.innerText === player.icon && boxMidRight.innerText === player.icon && boxBottomRight.innerText === player.icon) {
                console.log(player.name + ' has won');
                return true;
                // diag 1
            } else if (boxTopLeft.innerText === player.icon && boxMidMid.innerText === player.icon && boxBottomRight.innerText === player.icon) {
                console.log(player.name + ' has won');
                return true;
                // diag 2
            } else if (boxTopRight.innerText === player.icon && boxMidMid.innerText === player.icon && boxBottomLeft.innerText === player.icon) {
                console.log(player.name + ' has won');
                return true;
            } else  {
                return false;
            }
        }

// check if game over / all tiles are filled
const gameDraw = () => {
    if (turnCounter === 9){
        return true;
    } else {
        return false;
    }
}

// reset scores
    // find button
    const resetScoreButton = document.querySelector("#reset-scores");
    // create reset function
    const resetScores = () => {
        player1.score = 0;
        player2.score = 0;
        updateScore(player1);
        updateScore(player2);
        currentPlayer = player1;
    }
    // create event listener for button -> reset()
    resetScoreButton.addEventListener('click', resetScores);

/** winning message? https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_event_target 
 $(document).ready(function(){
  $("p, button, h1").click(function(event){
    $("div").html("Triggered by a " + event.target.nodeName + " element.");
  });
});
 */
