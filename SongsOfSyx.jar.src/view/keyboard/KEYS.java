/*     */ package view.keyboard;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import snake2d.CORE;
/*     */ import snake2d.KeyBoard;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class KEYS
/*     */   implements KeyPoller
/*     */ {
/*  15 */   static final KeyNames names = new KeyNames();
/*     */   
/*     */   private static KEYS self;
/*     */   private final KeyPageMain MAIN;
/*     */   private final KeyPageSett SETT;
/*     */   private final KeyPageWorld WORLD;
/*     */   private final KeyPageBattle BATTLE;
/*  22 */   private final IChange iii = new IChange();
/*     */   
/*     */   Key toChange;
/*     */   private final LIST<KeyPage> views;
/*     */   private boolean anyDown;
/*     */   
/*     */   private KEYS() {
/*  29 */     self = this;
/*     */     
/*  31 */     this.MAIN = new KeyPageMain();
/*  32 */     this.SETT = new KeyPageSett();
/*  33 */     this.WORLD = new KeyPageWorld();
/*  34 */     this.BATTLE = new KeyPageBattle();
/*  35 */     this.views = (LIST<KeyPage>)new ArrayList((Object[])new KeyPage[] {
/*  36 */           this.MAIN, this.SETT, this.WORLD, this.BATTLE
/*     */         });
/*     */   }
/*     */   
/*     */   public static LIST<KeyPage> pages() {
/*  41 */     return self.views;
/*     */   }
/*     */   
/*     */   public static KeyPageMain MAIN() {
/*  45 */     return self.MAIN;
/*     */   }
/*     */   
/*     */   public static KeyPageSett SETT() {
/*  49 */     return self.SETT;
/*     */   }
/*     */   
/*     */   public static KeyPageWorld WORLD() {
/*  53 */     return self.WORLD;
/*     */   }
/*     */   
/*     */   public static KeyPageBattle BATTLE() {
/*  57 */     return self.BATTLE;
/*     */   }
/*     */   
/*     */   public static KEYS get() {
/*  61 */     return self;
/*     */   }
/*     */   
/*     */   public static KeyPoller init() {
/*  65 */     self = new KEYS();
/*  66 */     return self;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void poll(LIST<KeyBoard.KeyEvent> keys) {
/*  74 */     KeyPage other = this.MAIN;
/*  75 */     if (VIEW.s().isActive()) {
/*  76 */       other = this.SETT;
/*  77 */     } else if (VIEW.world().isActive()) {
/*  78 */       other = this.WORLD;
/*  79 */     } else if ((VIEW.s()).battle.isActive() || VIEW.b().isActive()) {
/*  80 */       other = this.BATTLE;
/*     */     } 
/*  82 */     for (KeyPage m : self.views) {
/*  83 */       if (m == this.MAIN || m == other) {
/*  84 */         for (Key k : m.all) {
/*  85 */           if (k.action != null && k.consumeClick()) {
/*  86 */             k.action.exe();
/*     */           }
/*     */         } 
/*     */       }
/*  90 */       for (Key k : m.all) {
/*  91 */         k.isDown = false;
/*  92 */         k.pressed = false;
/*     */       } 
/*     */     } 
/*  95 */     self.anyDown = false;
/*     */     
/*  97 */     int mod = -1;
/*     */     
/*  99 */     for (Key k : this.MAIN.all) {
/* 100 */       k.isDown = false;
/* 101 */       k.pressed = false;
/* 102 */       if (mod == -1 && k.modCode() != -1 && CORE.getInput().getKeyboard().isPressed(k.modCode())) {
/* 103 */         mod = k.modCode();
/* 104 */         this.anyDown = true;
/*     */       } 
/*     */     } 
/* 107 */     if (other != null) {
/* 108 */       for (Key k : other.all) {
/* 109 */         k.isDown = false;
/* 110 */         k.pressed = false;
/* 111 */         if (mod == -1 && k.modCode() != -1 && CORE.getInput().getKeyboard().isPressed(k.modCode())) {
/* 112 */           mod = k.modCode();
/* 113 */           this.anyDown = true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 118 */     for (KeyBoard.KeyEvent e : keys) {
/* 119 */       if (e.action() == KeyBoard.KEYACTION.PRESS) {
/* 120 */         Key k = check(mod, e.code(), other);
/* 121 */         if (k != null) {
/* 122 */           k.pressed = true;
/* 123 */           this.anyDown = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 128 */     for (Key k : this.MAIN.all) {
/* 129 */       if (k.keyCode() != -1 && (k.modCode() == mod || (k.modCode() == -1 && k.keyCode() == mod)) && CORE.getInput().getKeyboard().isPressed(k.keyCode())) {
/* 130 */         k.isDown = true;
/* 131 */         this.anyDown = true;
/*     */       } 
/*     */     } 
/* 134 */     if (other != null) {
/* 135 */       for (Key k : other.all) {
/* 136 */         if (k.keyCode() != -1 && (k.modCode() == mod || (k.modCode() == -1 && k.keyCode() == mod)) && CORE.getInput().getKeyboard().isPressed(k.keyCode())) {
/* 137 */           k.isDown = true;
/* 138 */           this.anyDown = true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 144 */     if (this.toChange != null && this.MAIN.ASSIGN_HOTKEY.isDown) {
/* 145 */       this.iii.show(this.toChange);
/*     */       
/* 147 */       clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Key check(int mod, int code, KeyPage other) {
/* 153 */     if (mod != -1) {
/* 154 */       int c = Key.hash(mod, code);
/* 155 */       if (this.MAIN.map.contains(c))
/* 156 */         return (Key)this.MAIN.map.get(c); 
/* 157 */       if (other != null && other.map.contains(c)) {
/* 158 */         return (Key)other.map.get(c);
/*     */       }
/*     */     } 
/*     */     
/* 162 */     if (this.MAIN.map.contains(code))
/* 163 */       return (Key)this.MAIN.map.get(code); 
/* 164 */     if (other != null && other.map.contains(code)) {
/* 165 */       return (Key)other.map.get(code);
/*     */     }
/* 167 */     return null;
/*     */   }
/*     */   
/*     */   public void restore() {
/* 171 */     for (KeyPage m : this.views) {
/* 172 */       for (Key k : m.all) {
/* 173 */         k.reset();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean anyDown() {
/* 179 */     return self.anyDown;
/*     */   }
/*     */   
/*     */   public static boolean moveDown() {
/* 183 */     return !(!self.MAIN.SCROLL_LEFT.isDown && !self.MAIN.SCROLL_RIGHT.isDown && !self.MAIN.SCROLL_UP.isDown && !self.MAIN.SCROLL_DOWN.isDown);
/*     */   }
/*     */   
/*     */   public static void bind(Key key) {
/* 187 */     clear();
/* 188 */     self.iii.show(key);
/*     */   }
/*     */   
/*     */   public static void clear() {
/* 192 */     for (KeyPage m : self.views) {
/* 193 */       for (Key k : m.all) {
/* 194 */         k.isDown = false;
/* 195 */         k.pressed = false;
/*     */       } 
/*     */     } 
/* 198 */     self.anyDown = false;
/* 199 */     self.toChange = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void readSettings() {
/* 204 */     restore();
/* 205 */     if (!(PATHS.local()).SETTINGS.exists("Keyboard")) {
/*     */       return;
/*     */     }
/*     */     try {
/* 209 */       Json json = new Json((PATHS.local()).SETTINGS.gets("Keyboard"));
/*     */ 
/*     */       
/* 212 */       for (int ii = 0; ii < this.views.size(); ii++) {
/* 213 */         KeyPage m = (KeyPage)this.views.get(ii);
/*     */         
/* 215 */         if (json.has(m.key)) {
/* 216 */           Json j = json.json(m.key);
/* 217 */           for (int ki = 0; ki < m.all.size(); ki++) {
/* 218 */             Key k = (Key)m.all.get(ki);
/* 219 */             k.read(j);
/*     */           } 
/*     */         } 
/*     */       } 
/* 223 */     } catch (Exception e) {
/* 224 */       e.printStackTrace(System.out);
/* 225 */       restore();
/* 226 */       save();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save() {
/* 234 */     JsonE json = new JsonE();
/* 235 */     for (KeyPage m : this.views) {
/* 236 */       JsonE j = new JsonE();
/*     */       
/* 238 */       for (Key k : m.all) {
/* 239 */         k.save(j);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 261 */       json.add(m.key, j);
/*     */     } 
/*     */     
/* 264 */     if (!(PATHS.local()).SETTINGS.exists("Keyboard"))
/* 265 */       (PATHS.local()).SETTINGS.create("Keyboard"); 
/* 266 */     json.save((PATHS.local()).SETTINGS.get("Keyboard"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\keyboard\KEYS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */