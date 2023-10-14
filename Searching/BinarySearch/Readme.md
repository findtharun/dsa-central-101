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
The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.

```
arr[ind] > = x; If no Index Found Lower Bound = Size of the Array

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
The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.

```
arr[ind] > x; If no Index Found Lower Bound = Size of the Array

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