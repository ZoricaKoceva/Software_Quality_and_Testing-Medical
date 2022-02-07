import products from "../../Products/ProductList/products";

const timeout = process.env.SLOWMO ? 30000 : 10000;

beforeAll(async () => {
    await products.goto(URL, {waitUntil: 'domcontentloaded'});
});

describe('Test header and title of the page', () => {
    test('Title of the page', async () => {
        const title = await products().title();
        expect(title).toBe('E-SHOP React App');
    }, timeout);

    test('Header of the page', async () => {
        const headerHandle = await products().$('.product_header');
        const html = await products().evaluate(headerHandle => headerHandle.innerHTML, headerHandle);

        expect(html).toBe("All products");
    }, timeout);
});
