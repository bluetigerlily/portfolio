<<<<<<< HEAD
function counter(){
    let count = 0;
    return function getCounter(){
        count++;
        return count;        
=======
function counter() {
    let count = 0;
    return function getCount() {
        count++;
        return count;
>>>>>>> 91be88e4f9892880b967f9e1a04c2afa162838bb
    }
}

let increment = counter();
<<<<<<< HEAD
=======

>>>>>>> 91be88e4f9892880b967f9e1a04c2afa162838bb
let count1 = increment();
let count2 = increment();
let count3 = increment();

<<<<<<< HEAD
console.log(count1+ ',' + count2+ ',' + count3);

function counter2(){

   let count = 0;
    return {
            'setCount': (x) =>(this.count=x), //this wont work
              'getCount': () => {return this.count} //this wont work
            } 
        
         }       
                   }
let obj=counter2();
let x = getCount();
obj.setCount(x+1);
console.log(obj.getCount());
=======
console.log(count1 + ',' + count2 + ',' + count3);

function counter2() {
    let count = 0;
    return {
        //'count':0,
        'setCount': (x) => {count = x},
        'getCount': () => {return count}
    }
}

let obj = counter2();
let x = obj.getCount();
obj.setCount(x+1);
console.log(obj.getCount());
>>>>>>> 91be88e4f9892880b967f9e1a04c2afa162838bb
