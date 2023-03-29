const { faker } = require('@faker-js/faker');
const { appendFileSync } = require('fs');

const FILE_PATH = '../data/products.csv';
const ROW_NUMBER = 1000;

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

for (let i = 0; i < ROW_NUMBER; i++) {
  const product = generateProduct();
  const row = arrayToRow(product);
  appendFileSync(FILE_PATH, row);
}
