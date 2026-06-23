/*     */ package view.keyboard;
/*     */ 
/*     */ import snake2d.KEYCODES;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class Key
/*     */   implements INDEXED
/*     */ {
/*  16 */   private static Str stmp = new Str(64);
/*     */   
/*  18 */   private static CharSequence ¤¤none = "---";
/*  19 */   private static CharSequence ¤¤hotkey = "¤Hotkey: ";
/*     */   
/*     */   static {
/*  22 */     D.ts(Key.class);
/*     */   }
/*     */   private final int modCodeDef;
/*     */   private final int keyCodeDef;
/*  26 */   private int modCode = -1;
/*  27 */   private int keyCode = -1;
/*     */   private final KeyPage map;
/*     */   public final String key;
/*     */   public final CharSequence name;
/*     */   public final CharSequence desc;
/*     */   ACTION action;
/*     */   boolean isDown;
/*     */   boolean pressed;
/*     */   public final boolean rebindable;
/*     */   
/*     */   Key(String key, CharSequence name, CharSequence desc, KeyPage map) {
/*  38 */     this(key, name, desc, map, -1, -1);
/*     */   }
/*     */   
/*     */   Key(String key, CharSequence name, CharSequence desc, KeyPage map, int defCode) {
/*  42 */     this(key, name, desc, map, -1, defCode);
/*     */   }
/*     */   
/*     */   Key(String key, CharSequence name, CharSequence desc, KeyPage map, int defMod, int defCode) {
/*  46 */     this(key, name, desc, map, defMod, defCode, true);
/*     */   }
/*     */   
/*     */   public KeyPage page() {
/*  50 */     return this.map;
/*     */   }
/*     */ 
/*     */   
/*     */   Key(String key, CharSequence name, CharSequence desc, KeyPage map, int defMod, int defCode, boolean bindable) {
/*  55 */     this.key = key;
/*  56 */     this.name = name;
/*  57 */     this.desc = desc;
/*  58 */     this.map = map;
/*  59 */     this.modCodeDef = defMod;
/*  60 */     this.keyCodeDef = defCode;
/*  61 */     assign(defMod, defCode);
/*  62 */     this.rebindable = bindable;
/*  63 */     for (Key k : map.all) {
/*  64 */       if (k.key.equals(key))
/*  65 */         throw new RuntimeException(k.key); 
/*  66 */     }  map.all.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   void read(Json json) {
/*  71 */     if (json.has(this.key)) {
/*  72 */       int i = json.i(this.key);
/*  73 */       if (i == -1) {
/*  74 */         assign(-1, -1);
/*     */       } else {
/*  76 */         int mod = i / KEYCODES.lastCode();
/*  77 */         mod--;
/*  78 */         int code = i % KEYCODES.lastCode();
/*  79 */         assign(mod, code);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void save(JsonE json) {
/*  85 */     int i = (this.keyCode == -1) ? -1 : index();
/*  86 */     json.add(this.key, i);
/*     */   }
/*     */   
/*     */   public boolean assign(int mod, int key) {
/*  90 */     if (mod == this.modCode && key == this.keyCode) {
/*  91 */       return true;
/*     */     }
/*  93 */     if (key != -1) {
/*  94 */       if (this.map != KEYS.MAIN() && KEYS.MAIN() != null && (KEYS.MAIN()).map.contains(hash(mod, key))) {
/*  95 */         if (!((Key)(KEYS.MAIN()).map.get(hash(mod, key))).rebindable)
/*  96 */           return false; 
/*  97 */         ((Key)(KEYS.MAIN()).map.get(hash(mod, key))).assign(-1, -1);
/*     */       } 
/*  99 */       if (this.map == KEYS.MAIN() && KEYS.pages() != null) {
/* 100 */         for (KeyPage p : KEYS.pages()) {
/* 101 */           if (p == KEYS.MAIN()) {
/*     */             continue;
/*     */           }
/* 104 */           if (p.map.contains(hash(mod, key))) {
/* 105 */             ((Key)p.map.get(hash(mod, key))).assign(-1, -1);
/*     */           }
/*     */         } 
/*     */       }
/* 109 */       if (this.map.map.contains(hash(mod, key))) {
/* 110 */         if (!((Key)this.map.map.get(hash(mod, key))).rebindable)
/* 111 */           return false; 
/* 112 */         ((Key)this.map.map.get(hash(mod, key))).assign(-1, -1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 117 */     if (this.keyCode != -1)
/* 118 */       this.map.map.remove(index()); 
/* 119 */     this.modCode = mod;
/* 120 */     this.keyCode = key;
/* 121 */     if (this.keyCode != -1)
/* 122 */       this.map.map.add(this); 
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   public void reset() {
/* 127 */     assign(this.modCodeDef, this.keyCodeDef);
/*     */   }
/*     */   
/*     */   public int modCode() {
/* 131 */     return this.modCode;
/*     */   }
/*     */   
/*     */   public int keyCode() {
/* 135 */     return this.keyCode;
/*     */   }
/*     */   
/*     */   public CharSequence repr() {
/* 139 */     if (this.keyCode == -1)
/* 140 */       return ¤¤none; 
/* 141 */     stmp.clear();
/* 142 */     if (this.modCode != -1) {
/* 143 */       CharSequence charSequence = KEYS.names.getCode(this.modCode);
/* 144 */       stmp.add(charSequence);
/* 145 */       stmp.s().add('+').s();
/*     */     } 
/* 147 */     CharSequence code = KEYS.names.getCode(this.keyCode);
/* 148 */     stmp.add(code);
/* 149 */     return (CharSequence)stmp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMapping(GUI_BOX box) {
/* 155 */     GBox b = (GBox)box;
/* 156 */     b.textLL(¤¤hotkey);
/* 157 */     b.text(repr());
/*     */   }
/*     */   
/*     */   static int hash(int modCode, int keyCode) {
/* 161 */     if (keyCode == -1)
/* 162 */       throw new RuntimeException(); 
/* 163 */     if (modCode == -1)
/* 164 */       return keyCode; 
/* 165 */     return (modCode + 1) * KEYCODES.lastCode() + keyCode;
/*     */   }
/*     */   
/*     */   public boolean hasMapping() {
/* 169 */     return (this.keyCode >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 174 */     return hash(this.modCode, this.keyCode);
/*     */   }
/*     */   
/*     */   public boolean isPressed() {
/* 178 */     return this.isDown;
/*     */   }
/*     */   
/*     */   public boolean consumeClick() {
/* 182 */     if (this.pressed) {
/* 183 */       this.pressed = false;
/* 184 */       return true;
/*     */     } 
/* 186 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 191 */     return this.map.key + " " + this.map.key;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\keyboard\Key.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */