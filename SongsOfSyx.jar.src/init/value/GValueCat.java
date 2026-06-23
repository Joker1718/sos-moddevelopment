/*     */ package init.value;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ public class GValueCat<T>
/*     */ {
/*  18 */   private final KeyMap<Value<T>> map = new KeyMap();
/*     */   private LIST<Value<T>> all;
/*  20 */   LinkedList<ACTION> inits = new LinkedList();
/*     */   boolean hasSpewed = false;
/*     */   public final String key;
/*  23 */   public Locks LOCK = new Locks();
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean eee;
/*     */ 
/*     */ 
/*     */   
/*     */   void clear() {
/*  32 */     this.map.clear();
/*  33 */     this.inits.clear();
/*  34 */     this.hasSpewed = false;
/*  35 */     this.LOCK.clear();
/*     */   }
/*     */   
/*     */   public KeyMap<Value<T>> map() {
/*  39 */     return this.map;
/*     */   }
/*     */   
/*     */   void init() {
/*  43 */     for (ACTION a : this.inits)
/*  44 */       a.exe(); 
/*  45 */     this.inits.clear();
/*  46 */     this.LOCK.init();
/*  47 */     this.all = this.map.allSorted();
/*     */   }
/*     */   
/*     */   public LIST<Value<T>> all() {
/*  51 */     return this.all;
/*     */   }
/*     */ 
/*     */   
/*     */   public void push(Value<T> value) {
/*  56 */     if (this.map.containsKey(value.key))
/*  57 */       throw new RuntimeException("Another value has the same key: " + value.key); 
/*  58 */     this.map.put(value.key, value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void push(String key, CharSequence name, SPRITE icon, DOUBLE_O<T> value, boolean isPercentage) {
/*  64 */     Value<T> v = new Value<>(key, icon, name, value, isPercentage, false);
/*  65 */     push(v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void push(String key, CharSequence name, SPRITE icon, DOUBLE_O<T> value, boolean isPercentage, boolean isBool) {
/*  71 */     Value<T> v = new Value<>(key, icon, name, value, isPercentage, isBool);
/*  72 */     push(v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void push(String key, CharSequence name, SPRITE icon, final BOOLEANO<T> value) {
/*  78 */     DOUBLE_O<T> v = new DOUBLE_O<T>()
/*     */       {
/*     */         public double getD(T t)
/*     */         {
/*  82 */           return (value.is(t) ? true : false);
/*     */         }
/*     */       };
/*     */     
/*  86 */     push(key, name, icon, v, false, true);
/*     */   }
/*     */   
/*     */   public void push(String key, CharSequence name, SPRITE icon, DOUBLE_O<T> value) {
/*  90 */     push(key, name, icon, value, true);
/*     */   }
/*     */   
/*     */   public void pushI(String key, CharSequence name, SPRITE icon, final INT_O<T> value) {
/*  94 */     DOUBLE_O<T> v = new DOUBLE_O<T>()
/*     */       {
/*     */         public double getD(T t)
/*     */         {
/*  98 */           return value.get(t);
/*     */         }
/*     */       };
/*     */     
/* 102 */     push(key, name, icon, v, false);
/*     */   }
/*     */   
/*     */   public Value<T> get(String key) {
/* 106 */     return (Value<T>)this.map.get(key);
/*     */   }
/*     */   
/*     */   GValueCat(String key) {
/* 110 */     this.eee = false;
/*     */     this.key = key; } public LIST<Value<T>> get(String key, Json error) {
/* 112 */     ArrayListGrower<Value<T>> res = new ArrayListGrower();
/* 113 */     if (key.indexOf('*') > 0) {
/* 114 */       String s = key.substring(0, key.indexOf('*'));
/* 115 */       for (Value<T> v : this.all) {
/* 116 */         if (v.key.startsWith(s))
/* 117 */           res.add(v); 
/*     */       } 
/*     */     } else {
/* 120 */       Value<T> v = (Value<T>)this.map.get(key);
/* 121 */       if (v == null) {
/* 122 */         String e = error.errorGet("No " + this.key + " named: " + key, key);
/* 123 */         if (!this.eee) {
/* 124 */           this.eee = true;
/* 125 */           e = e + " Available:";
/* 126 */           e = e + e;
/* 127 */           e = e + e;
/*     */         } 
/* 129 */         LOG.err(e);
/*     */       } else {
/* 131 */         res.add(v);
/*     */       } 
/*     */     } 
/* 134 */     return (LIST<Value<T>>)res;
/*     */   }
/*     */   
/*     */   public String available() {
/* 138 */     return this.map.keysString();
/*     */   }
/*     */   
/*     */   public final class Locks
/*     */   {
/* 143 */     final KeyMap<Lockable<T>> map = new KeyMap();
/* 144 */     LinkedList<ACTION> inits = new LinkedList();
/*     */     boolean hasSpewed = false;
/* 146 */     public final Lockable<T> empty = new Lockable<>("", "", "", (SPRITE)(UI.icons()).s.DUMMY, GValueCat.this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void init() {
/* 152 */       for (ACTION a : this.inits)
/* 153 */         a.exe(); 
/* 154 */       this.inits.clear();
/*     */     }
/*     */     
/*     */     void clear() {
/* 158 */       this.map.clear();
/* 159 */       this.inits.clear();
/* 160 */       this.hasSpewed = false;
/*     */     }
/*     */     
/*     */     public Lockable<T> get(String key) {
/* 164 */       return (Lockable<T>)this.map.get(key);
/*     */     }
/*     */     
/*     */     public String available() {
/* 168 */       return this.map.keysString();
/*     */     }
/*     */     
/*     */     public Lockable<T> push(String key, CharSequence name, CharSequence desc, SPRITE icon) {
/* 172 */       key = key.replace("__", "_");
/* 173 */       Lockable<T> t = new Lockable<>(key, name, desc, icon, GValueCat.this);
/* 174 */       this.map.put(key, t);
/* 175 */       return t;
/*     */     }
/*     */     
/*     */     public Lockable<T> push() {
/* 179 */       Lockable<T> t = new Lockable<>("", "", "", (SPRITE)(UI.icons()).s.DUMMY, GValueCat.this);
/* 180 */       return t;
/*     */     }
/*     */   }
/*     */   
/*     */   public abstract class LockJson {
/*     */     final Json json;
/*     */     
/*     */     public abstract void callback(COMPARATOR param1COMPARATOR, Value<T> param1Value, String param1String, Json param1Json);
/*     */     
/*     */     public LockJson(String key, Json j) {
/* 190 */       this.json = j.json(key);
/* 191 */       GValueCat.this.inits.add(new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/* 195 */               for (String keyComp : GValueCat.LockJson.this.json.keys()) {
/* 196 */                 COMPARATOR comp = (COMPARATOR)COMPARATOR.map.get(keyComp, GValueCat.LockJson.this.json);
/* 197 */                 if (comp != null) {
/* 198 */                   Json j = GValueCat.LockJson.this.json.json(keyComp);
/* 199 */                   for (String k : j.keys()) {
/* 200 */                     Value<T> v = GValueCat.LockJson.access$0(GValueCat.LockJson.this).get(k);
/* 201 */                     if (v == null)
/*     */                       continue; 
/* 203 */                     GValueCat.LockJson.this.callback(comp, v, k, j);
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\GValueCat.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */