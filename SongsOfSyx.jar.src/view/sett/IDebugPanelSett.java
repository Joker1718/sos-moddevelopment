/*     */ package view.sett;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.TreeMap;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEAN;
/*     */ import util.gui.misc.GButt;
/*     */ import view.interrupter.IDebugPanelAbs;
/*     */ import view.interrupter.InterManager;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ 
/*     */ public class IDebugPanelSett
/*     */   extends IDebugPanelAbs {
/*  19 */   private static final TreeMap<CharSequence, CLICKABLE> hash = new TreeMap<>();
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
/*     */   private static CLICKABLE get(CharSequence name, final BOOLEAN.BOOLEAN_MUTABLE toggle) {
/*  32 */     GButt.Checkbox c = new GButt.Checkbox((UI.FONT()).S.getText(name))
/*     */       {
/*     */         protected void clickA() {
/*  35 */           selectedToggle();
/*  36 */           toggle.set(selectedIs());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  41 */           selectedSet(toggle.is());
/*  42 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */       };
/*  45 */     return (CLICKABLE)c;
/*     */   }
/*     */   
/*     */   private static CLICKABLE get(CharSequence name, ACTION action) {
/*  49 */     GButt.Glow glow = new GButt.Glow((UI.FONT()).S.getText(name))
/*     */       {
/*     */         protected void clickA() {
/*  52 */           (VIEW.s()).debug.hide();
/*     */         }
/*     */       };
/*  55 */     glow.clickActionSet(action);
/*  56 */     return (CLICKABLE)glow;
/*     */   }
/*     */   
/*     */   public static void add(String name, BOOLEAN.BOOLEAN_MUTABLE toggle) {
/*  60 */     put(name, get(name, toggle)); } public static void add(String name, PLACABLE... placables) {
/*     */     byte b;
/*     */     int i;
/*     */     PLACABLE[] arrayOfPLACABLE;
/*  64 */     for (i = (arrayOfPLACABLE = placables).length, b = 0; b < i; ) { final PLACABLE p = arrayOfPLACABLE[b];
/*  65 */       put(name + ": " + name, get(name + ": " + name, new ACTION()
/*     */             {
/*     */               public void exe() {
/*  68 */                 (VIEW.s()).tools.place(p);
/*     */               }
/*     */             }));
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public static void add(String name, Iterable<PLACABLE> placables) {
/*  75 */     for (PLACABLE p : placables) {
/*  76 */       put(name + ": " + name, get(name + ": " + name, new ACTION()
/*     */             {
/*     */               public void exe() {
/*  79 */                 (VIEW.s()).tools.place(p);
/*     */               }
/*     */             }));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void add(final PLACABLE placable) {
/*  86 */     put(placable.name(), get(placable.name(), new ACTION()
/*     */           {
/*     */             public void exe() {
/*  89 */               (VIEW.s()).tools.place(placable);
/*     */             }
/*     */           }));
/*     */   }
/*     */   
/*     */   public static void add(String key, ACTION action) {
/*  95 */     put(key, get(key, action));
/*     */   }
/*     */   
/*     */   public static void add(String prefix, final PLACABLE placable) {
/*  99 */     put(prefix + ": " + prefix, get(prefix + ": " + prefix, new ACTION()
/*     */           {
/*     */             public void exe() {
/* 102 */               (VIEW.s()).tools.place(placable);
/*     */             }
/*     */           }));
/*     */   }
/*     */   
/*     */   private static void put(CharSequence key, CLICKABLE obj) {
/* 108 */     String s = String.valueOf(key);
/*     */     
/* 110 */     while (hash.containsKey(s))
/* 111 */       s = s + s + "I"; 
/* 112 */     hash.put(s.toLowerCase(), obj);
/*     */   }
/*     */ 
/*     */   
/*     */   IDebugPanelSett(InterManager m) {
/* 117 */     super(m, init());
/* 118 */     hash.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static TreeMap<CharSequence, CLICKABLE> init() {
/* 126 */     return hash;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\IDebugPanelSett.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */