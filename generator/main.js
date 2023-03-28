const { faker } = require('@faker-js/faker');
const { appendFileSync } = require('fs');

const generateProduct = () => [
  faker.commerce.productName(),
  faker.commerce.department(),
  faker.commerce.productDescription(),
  faker.commerce.price(),
  faker.image.imageUrl(),
  faker.date.past(),
];

const arrayToRow = (array) => {
  const enquotedArray = array.map((el) => `"${el}"`);
  return enquotedArray.join(',') + '\n';
};

for (let i = 0; i < 1000; i++) {
  const product = generateProduct();
  const row = arrayToRow(product);
  appendFileSync('contents.csv', row);
}
