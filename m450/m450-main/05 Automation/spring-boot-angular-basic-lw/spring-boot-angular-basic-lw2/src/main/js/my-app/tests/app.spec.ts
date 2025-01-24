import { test, expect } from '@playwright/test';

test('Test website availability', async ({ page }) => {
  const response = await page.goto('http://localhost:4200');
  expect(response?.status()).toBe(200);
});

test('Test navigation to List Students', async ({ page }) => {
  await page.goto('http://localhost:4200');
  await page.click('text=List Students');
  await expect(page).toHaveURL(/\/students/);
});

test('Test displaying students', async ({ page }) => {
  await page.goto('http://localhost:4200/students');
  const table = page.locator('table');
  await expect(table).toBeVisible();
  const rows = await table.locator('tbody tr').count();
  expect(rows).toBeGreaterThan(0);
});

test('Test submitting the student form', async ({ page }) => {
  await page.goto('http://localhost:4200/addstudents');
  await page.fill('input[name="name"]', 'Marwin Kohl');
  await page.fill('input[name="email"]', 'marwin@kohler.ch');
  await page.click('text=Submit');
  await expect(page).toHaveURL(/\/students/);
});
