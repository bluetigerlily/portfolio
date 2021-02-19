function counter(){
    let count = 0;
    return function getCounter(){
        count++;
        return count;        
    }
}

let increment = counter();
let count1 = increment();
let count2 = increment();
let count3 = increment();

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
