const { faker } = require("@faker-js/faker");

const generateProduct = () => ({
  name: faker.commerce.productName(),
  department: faker.commerce.department(),
  description: faker.commerce.productDescription(),
  price: faker.commerce.price(),
  image: faker.image.imageUrl(),
  releasedAt: faker.date.past(),
});

console.log(generateProduct()); // TODO: write to file
