function sum_nested_objects(values) {
    let sum = 0;

    for (let key in values) {
        if (typeof values[key] === 'object') {
            sum += sum_nested_objects(values[key]);
        } else {
            sum += values[key];
        }
    }

    return sum;
}

const d1 = {'k1': 2, 'k2': {"k1": 3, "k2": 5, "k3": {"k4": 2, "k5": 3}}};
const result = sum_nested_objects(d1);
console.log(result); // Output: 15