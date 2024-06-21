# Binary Search 

* Time Complexity : O(logN)
* mid = low + (high-low)/2

```
while(left <= right) {
    int mid =  left + (right-left)/2 ;
    if(nums[mid] < target) {
        left = mid+1;
    } else if(nums[mid] > target) {
        right = mid-1;
    }else {
        return mid;
    }
}
        
```

## Lower Bound
The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given value.
Practice here : https://www.naukri.com/code360/problems/lower-bound_8165382
```
arr[ind] > = x; If no Index Found then Lower Bound = Size of the Array
int lower_bound = n;
while(low<=high){
    int mid = low + (high-low)/2;
    if(arr[mid]>=x){
        lower_bound = mid;
        high = mid-1;
    }else{  
        low = mid+1;
    }
}
return lower_bound;
```

## Upper Bound
 The upper bound in a sorted array is the index of the first value that is greater than a given value.
 If no Index Found then Upper Bound = Size of the Array.
 Practice here : https://www.naukri.com/code360/problems/implement-upper-bound_8165383
```
int upper_bound = n;
while(low<=high){
    int mid = low + (high-low)/2;
    if(arr[mid]>x){
        upper_bound = mid;
        high = mid-1;
    }else{
        low = mid+1;
    }
}
return upper_bound;
```