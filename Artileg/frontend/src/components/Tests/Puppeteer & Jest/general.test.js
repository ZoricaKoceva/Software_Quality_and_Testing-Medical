import products from "../../Products/ProductList/products";

const timeout = process.env.SLOWMO ? 30000 : 10000;

beforeAll(async () => {
    await products.goto(URL, {waitUntil: 'domcontentloaded'});
});

describe('General Tests', () => {
    test('Intercept Request', async () => {
        await products().setRequestInterception(true);
        products().on('request', interceptedRequest => {
            if (interceptedRequest.url().endsWith('.png')) {
                interceptedRequest.abort();
            } else {
                interceptedRequest.continue();
            }
        });
        await products().reload({waitUntil: 'networkidle0'});

        await products().setRequestInterception(false);
    }, timeout);

    test('Target newly opened page', async () => {
        const newPagePromise = new Promise(resolve => browser.once('targetcreated', target => resolve(target.page())));
        await products().click('.repo_link');

        const newPage = await newPagePromise;
        const title = await newPage.title();
        await newPage.close();

        expect(title).toBe('ZoricaKoceva/Software_Quality_and_Testing-Medical');
    }, timeout);
});


