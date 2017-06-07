function findTheDifference(s, t) {
  var xor = 0;
  for (var i = 0; i < s.length + t.length; i += 1) {
    if (i < s.length) {
      xor ^= s.charCodeAt(i);
    } else {
      xor ^= t.charCodeAt(i - s.length);
    }
  }

  return String.fromCharCode(xor);
}

console.log(findTheDifference("abcd", "abecd"));
