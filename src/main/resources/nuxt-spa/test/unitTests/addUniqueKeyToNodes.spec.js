

import {addUniqueKeyToNodes} from "../utils/serviceUtils";
import {ServicesMockData} from "../mock_data/ServicesMockData";

describe("add unique key to nodes", () => {
  test("it should not throw error", () => {
   const input = ServicesMockData();
    expect(() => {
      addUniqueKeyToNodes(input);
    }).not.toThrow();
  });
});
