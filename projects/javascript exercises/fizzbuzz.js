//Selectors
const numberInput = document.querySelector('.number-input');
const numberButton = document.querySelector('.number-button');
const numberList = document.querySelector('.number-list');


//Event listeners
numberButton.addEventListener('click', addnumber);
numberList.addEventListener('click', deletenumber);



//functions
function addnumber(event)
{

   //Prevent form from submitting
   event.preventDefault();
   //add number Div event to class list
   const numberDiv = document.createElement('div');
   numberDiv.classList.add('number');
   //create number Element
   const newnumber = document.createElement('li');
   
   newnumber.innerText = numberInput.value;
   newnumber.classList.add('number-item');
    //trash button
  
    const trashButton = document.createElement('button');
    trashButton.innerHTML = '<i class="fa fa-trash" aria-hidden="true"></i>';  
    trashButton.classList.add('trash-btn'); 
    numberDiv.appendChild(trashButton);
   
    if (numberInput.value%3 && 5===0)
    {
        numberDiv.appendChild(((newnumber.value).replaceValue(numberInput.value,"FizzBuzz")));
    }
    if ((numberInput.value)%3==0)
    {
      numberDiv.appendChild(((newnumber.value).replaceValue(numberInput.value,"Fizz")));
    }
     if((numberInput.value)%5==0)
    {
      numberDiv.appendChild(((newnumber.value).replaceValue(numberInput.value,"Buzz")));
    }

    //append to list
    numberDiv.appendChild(newnumber);
    numberList.appendChild(numberDiv);
    //clear number input
    numberInput.value ='';
}


function deletenumber(event)
    {
    const item = event.target;
    if (item.classList[0] === 'trash-btn')
    {
        const number =item.parentElement;
        //animation
        number.classList.add("fall");
        number.addEventListener('transitionend',function()
        {
            number.remove();
        });
    }
    console.log(event.target);
    }
