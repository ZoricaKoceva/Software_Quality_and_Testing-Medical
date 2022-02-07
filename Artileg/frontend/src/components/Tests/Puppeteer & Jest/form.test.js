import products from "../../Products/ProductList/products";

const timeout = process.env.SLOWMO ? 30000 : 10000;

beforeAll(async () => {
    await products.goto(URL, {waitUntil: 'domcontentloaded'});
});

describe('Test form', () => {
    test('Submit form with valid data', async () => {
        await products().click('[href="/login"]');

        await products().waitForSelector('form');
        await products().type('#name', 'Andrej');

        await products().type('#password','testiranje');
        await products().type('#repeat_password','testiranje');

        await products().click('[type="submit"]');

        await products().waitForSelector('.success');
        const html = await products().$eval('.success', el => el.innerHTML);

        expect(html).toBe('Successfully signed up!');
    }, timeout);

    test('Submit form with invalid data', async () => {
        await products().goto(`${URL}/login`, {waitUntil: 'domcontentloaded'});

        await products().waitForSelector('form');
        await products().type('#name', 'Andrej');

        await products().type('#password','testiranje');
        await products().type('#repeat_password','programiranje');

        await products().click('[type="submit"]');

        await products().waitForSelector('.error');
        const html = await products().$eval('.error', el => el.innerHTML);

        expect(html).toBe('Passwords do not match!');
    }, timeout);
});
