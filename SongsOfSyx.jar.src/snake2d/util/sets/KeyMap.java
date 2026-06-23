/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class KeyMap<T>
/*     */ {
/*   9 */   private final HashMap<String, T> map = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(String key, T t) {
/*  16 */     if (this.map.containsKey(key))
/*  17 */       throw new RuntimeException("'" + key + "' " + this.map.get(key) + " " + t); 
/*  18 */     this.map.put(key, t);
/*     */   }
/*     */   
/*     */   public void putReplace(String key, T t) {
/*  22 */     this.map.put(key, t);
/*     */   }
/*     */   
/*     */   public void remove(String key) {
/*  26 */     this.map.remove(key);
/*     */   }
/*     */   
/*     */   public boolean containsKey(String key) {
/*  30 */     return this.map.containsKey(key);
/*     */   }
/*     */   
/*     */   public T get(String key) {
/*  34 */     return this.map.get(key);
/*     */   }
/*     */   
/*     */   public void debug() {
/*  38 */     for (String s : this.map.keySet())
/*  39 */       System.err.println(s); 
/*     */   }
/*     */   
/*     */   public void expand() {
/*  43 */     ArrayList<String> bb = new ArrayList<>(50);
/*  44 */     for (String s : this.map.keySet()) {
/*  45 */       if (s.startsWith("_")) {
/*     */         
/*  47 */         String key = s.substring(1, s.length());
/*  48 */         if (this.map.containsKey(key))
/*     */           continue; 
/*  50 */         bb.add(s);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  55 */     for (String s : bb)
/*     */     {
/*  57 */       this.map.put(s.substring(1, s.length()), this.map.get(s));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  64 */     return this.map.size();
/*     */   }
/*     */   
/*     */   public LIST<T> all() {
/*  68 */     return new ArrayList<>(this.map.values());
/*     */   }
/*     */   
/*     */   public LIST<T> allSorted() {
/*  72 */     String[] keys = new String[this.map.values().size()];
/*  73 */     int i = 0;
/*  74 */     for (String k : keys()) {
/*  75 */       keys[i++] = k;
/*     */     }
/*  77 */     Arrays.sort((Object[])keys);
/*  78 */     ArrayList<T> res = new ArrayList<>(keys.length);
/*  79 */     for (i = 0; i < keys.length; i++)
/*  80 */       res.add(get(keys[i])); 
/*  81 */     return res;
/*     */   }
/*     */   
/*     */   public Set<String> keys() {
/*  85 */     return this.map.keySet();
/*     */   }
/*     */   
/*     */   public LIST<String> keysSorted() {
/*  89 */     String[] keys = new String[this.map.values().size()];
/*  90 */     int i = 0;
/*  91 */     for (String k : keys()) {
/*  92 */       keys[i++] = k;
/*     */     }
/*  94 */     Arrays.sort((Object[])keys);
/*  95 */     ArrayList<String> res = new ArrayList<>(keys.length);
/*  96 */     for (i = 0; i < keys.length; i++)
/*  97 */       res.add(keys[i]); 
/*  98 */     return res;
/*     */   }
/*     */   
/*     */   public String keysString() {
/* 102 */     String s = "";
/* 103 */     for (String ss : keysSorted()) {
/* 104 */       s = String.valueOf(s) + ss + System.lineSeparator();
/*     */     }
/* 106 */     return s;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 110 */     this.map.clear();
/*     */   }
/*     */   
/*     */   public static final class CharMap<T>
/*     */   {
/* 115 */     private String[] table = new String[0];
/* 116 */     private Object[] content = new Object[0];
/* 117 */     private int last = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     public void putReplace(String key, T t) {
/* 122 */       int i = search(key);
/* 123 */       if (i != -1) {
/* 124 */         this.content[i] = t;
/*     */       } else {
/* 126 */         put(key, t);
/*     */       } 
/*     */     }
/*     */     
/*     */     public T get(CharSequence key) {
/* 131 */       int i = search(key);
/* 132 */       if (i == -1)
/* 133 */         return null; 
/* 134 */       return (T)this.content[i];
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsKey(CharSequence key) {
/* 139 */       return (search(key) != -1);
/*     */     }
/*     */     
/*     */     public void remove(CharSequence key) {
/* 143 */       int i = search(key);
/* 144 */       if (i < 0)
/* 145 */         throw new RuntimeException(); 
/* 146 */       this.last--;
/* 147 */       for (; i < this.last; i++) {
/* 148 */         this.table[i] = this.table[i + 1];
/*     */       }
/*     */     }
/*     */     
/*     */     public int size() {
/* 153 */       return this.last;
/*     */     }
/*     */     
/*     */     public boolean isEmpty() {
/* 157 */       return (this.last == 0);
/*     */     }
/*     */     
/*     */     public int put(String key, T e) {
/* 161 */       if (search(key) != -1)
/* 162 */         throw new RuntimeException("'" + key + "' " + get(key) + " " + e); 
/* 163 */       this.last++;
/* 164 */       if (this.last >= this.table.length) {
/* 165 */         String[] table2 = new String[this.table.length + 1];
/* 166 */         Object[] content2 = new Object[this.table.length + 1];
/* 167 */         for (int j = 0; j < this.table.length; j++) {
/* 168 */           table2[j] = this.table[j];
/* 169 */           content2[j] = this.content[j];
/*     */         } 
/* 171 */         this.table = table2;
/* 172 */         this.content = content2;
/*     */       } 
/* 174 */       for (int i = this.last - 1; i >= 0; i--) {
/* 175 */         if (i == 0) {
/* 176 */           this.table[i] = key;
/* 177 */           this.content[i] = e;
/* 178 */           return 0;
/*     */         } 
/* 180 */         int comp = compare(key, i - 1);
/* 181 */         if (comp > 0) {
/* 182 */           this.table[i] = key;
/* 183 */           this.content[i] = e;
/* 184 */           return i;
/*     */         } 
/* 186 */         if (comp == 0)
/* 187 */           throw new RuntimeException(); 
/* 188 */         this.table[i] = this.table[i - 1];
/* 189 */         this.content[i] = this.content[i - 1];
/*     */       } 
/* 191 */       return -1;
/*     */     }
/*     */     
/*     */     private int compare(CharSequence key, int index) {
/* 195 */       String other = this.table[index];
/* 196 */       int le = Math.max(key.length(), other.length());
/*     */       
/* 198 */       for (int i = 0; i < le; i++) {
/* 199 */         if (i >= key.length())
/* 200 */           return -1; 
/* 201 */         if (i >= other.length())
/* 202 */           return 1; 
/* 203 */         int bb = key.charAt(i) - other.charAt(i);
/* 204 */         if (bb != 0)
/* 205 */           return bb; 
/*     */       } 
/* 207 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private int search(CharSequence key) {
/* 213 */       return runBinarySearchIteratively(key, 0, this.last - 1);
/*     */     }
/*     */ 
/*     */     
/*     */     private int runBinarySearchIteratively(CharSequence key, int low, int high) {
/* 218 */       while (low <= high) {
/* 219 */         int mid = low + (high - low) / 2;
/* 220 */         int comp = compare(key, mid);
/*     */         
/* 222 */         if (comp > 0) {
/* 223 */           low = mid + 1; continue;
/* 224 */         }  if (comp < 0) {
/* 225 */           high = mid - 1; continue;
/* 226 */         }  if (comp == 0) {
/* 227 */           return mid;
/*     */         }
/*     */       } 
/* 230 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public LIST<T> all() {
/* 235 */       ArrayList<T> tt = new ArrayList<>(this.content.length); byte b; int i; Object[] arrayOfObject;
/* 236 */       for (i = (arrayOfObject = this.content).length, b = 0; b < i; ) { Object o = arrayOfObject[b];
/* 237 */         tt.add((T)o); b++; }
/* 238 */        return tt;
/*     */     }
/*     */     
/*     */     public LIST<String> keysSorted() {
/* 242 */       ArrayList<String> res = new ArrayList<>((T[])this.table);
/* 243 */       return res;
/*     */     }
/*     */     
/*     */     public String keysString() {
/* 247 */       String s = "";
/* 248 */       for (String ss : keysSorted()) {
/* 249 */         s = String.valueOf(s) + ss + System.lineSeparator();
/*     */       }
/* 251 */       return s;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\KeyMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */