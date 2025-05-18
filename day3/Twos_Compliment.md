# Understanding 2's Complement and Sign Detection

This guide explains how to determine the **sign** of a binary number represented in **2's complement**, including step-by-step examples.

---

## **1. How 2's Complement Works**
2's complement is a method for representing **signed integers** in binary. The leftmost bit (**MSB**) indicates the sign:
- **`0` → Positive number** (or zero).
- **`1` → Negative number**.

### **Key Rules**
1. **Positive Numbers**: Directly convert binary to decimal.
2. **Negative Numbers**: To find the magnitude of a negative number, take its 2's complement.

---

## **2. Step-by-Step Sign Detection** (binary to decimal)

### **Step 1: Check the MSB (Most Significant Bit)**
- **If `MSB = 0`** → Number is **positive** (convert normally).
- **If `MSB = 1`** → Number is **negative** (proceed to Step 2).

### **Step 2: Compute the 2's Complement (for Negative Numbers)**
To find the magnitude of a negative number:
1. **Invert all bits** (change `1`→`0` and `0`→`1`).
2. **Add `1`** to the inverted result.
3. The final value is the **positive equivalent** of the original negative number.

---

## **3. Step-by-Step Sign Detection** (decimal to binary)

### **Step 1: find magnitude of decimal number**
- **If decimal is -8 find magnitude of `8`** and add `0` at MSB.
- **example :  `8` --> `1000` --> `01000`**

### **Step 2: Compute the 2's Complement**
To find the magnitude of a negative number:
1. **Invert all bits** (change `1`→`0` and `0`→`1`).
2. **Add `1`** to the inverted result.
3. The final value is the **binary form** of the original number.

#### **Note** : Above steps are for -ve numbers especially for positive number directly find out magnitude and add a MSB of 0 to it.
---


## **3. Examples**

### **Example 1: `11010` (5-bit 2's complement)**
| Step | Action | Binary Value | Explanation |
|------|--------|--------------|-------------|
| 1 | Check MSB | `1 1010` | MSB = `1` → **Negative** |
| 2 | Invert bits | `00101` | Flip all bits |
| 3 | Add `1` | `00110` (`6` in decimal) | `00101 + 1 = 00110` |
| 4 | Final Value | **`-6`** | Negative of the result |

**Conclusion**: `11010` in **5-bit 2's complement** = **`-6`**.

---

### **Example 2: `01101` (5-bit 2's complement)**
| Step | Action | Binary Value | Explanation |
|------|--------|--------------|-------------|
| 1 | Check MSB | `0 1101` | MSB = `0` → **Positive** |
| 2 | Direct Conversion | `13` | `0×16 + 1×8 + 1×4 + 0×2 + 1×1` |

**Conclusion**: `01101` = **`+13`**.

---

### **Example 3: `111010` (6-bit 2's complement)**
| Step | Action | Binary Value | Explanation |
|------|--------|--------------|-------------|
| 1 | Check MSB | `11 1010` | MSB = `1` → **Negative** |
| 2 | Invert bits | `000101` | Flip all bits |
| 3 | Add `1` | `000110` (`6` in decimal) | `000101 + 1 = 000110` |
| 4 | Final Value | **`-6`** | Negative of the result |

**Conclusion**: `111010` in **6-bit 2's complement** = **`-6`**.

---

## **4. Important Notes**
1. **Bit Length Matters**:  
   - `11010` in **5-bit** = `-6` (MSB = `1`).  
   - `11010` in **8-bit** = `00011010` = `+26` (MSB = `0`).  
2. **Range of Representable Numbers**:  
   - For **N bits**, the range is **`-2^(N-1)` to `2^(N-1)-1`**.  
   - Example: 5-bit → `-16` to `+15`.

---

## **5. Summary Table**
| Binary (5-bit) | MSB | Sign | 2's Complement Magnitude | Final Value |
|----------------|-----|------|--------------------------|-------------|
| `01010` | `0` | + | `1010` (direct) | `+10` |
| `11010` | `1` | - | `00110` (`6`) | `-6` |
| `10000` | `1` | - | `10000` (`16`) | `-16` |

---

## **6. References**
- [Two's Complement (Wikipedia)](https://en.wikipedia.org/wiki/Two%27s_complement)
- [Signed Number Representations (GeeksforGeeks)](https://www.geeksforgeeks.org/signed-representation-of-binary-numbers/)

---

✅ **Now you can determine the sign of any 2's complement binary number!**  
❓ **Try these practice problems:**  
1. What is `10111` (5-bit) in decimal?  ----> **solu -> -9**
2. Is `01001` (5-bit) positive or negative?  
3. Convert `11111100` (8-bit) to decimal.  ----> **solu -> -4**