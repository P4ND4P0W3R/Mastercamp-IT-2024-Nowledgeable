function multiplyBy2(values) {
  var newList = [];
  for (var i in values) {
    newList.push(values[i] * 2);
  }
  return newList;
}
