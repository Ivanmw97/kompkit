import { describe, it, expect, vi } from "vitest";
import { debounce, isEmail, formatCurrency } from "../src";

describe("isEmail", () => {
  it("returns true for valid emails", () => {
    expect(isEmail("test@example.com")).toBe(true);
  });
  it("returns false for invalid emails", () => {
    expect(isEmail("invalid@")).toBe(false);
  });
});

describe("formatCurrency", () => {
  it("formats EUR by default", () => {
    const result = formatCurrency(1234.56);
    expect(result.includes("€")).toBe(true);
  });
});

describe("debounce", () => {
  it("calls the function after the wait time", async () => {
    const mock = vi.fn();
    const fn = debounce(mock, 200);
    fn();
    expect(mock).not.toHaveBeenCalled();
    await new Promise((r) => setTimeout(r, 250));
    expect(mock).toHaveBeenCalled();
  });
});
