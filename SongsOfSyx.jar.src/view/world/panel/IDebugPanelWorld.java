/*     */ package view.world.panel;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.TreeMap;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.map.MAP_PLACER;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEAN;
/*     */ import util.gui.misc.GButt;
/*     */ import view.interrupter.IDebugPanelAbs;
/*     */ import view.interrupter.InterManager;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ public class IDebugPanelWorld
/*     */   extends IDebugPanelAbs {
/*  23 */   private static final TreeMap<CharSequence, CLICKABLE> hash = new TreeMap<>();
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
/*  36 */     GButt.Checkbox c = new GButt.Checkbox((UI.FONT()).S.getText(name))
/*     */       {
/*     */         protected void clickA() {
/*  39 */           selectedToggle();
/*  40 */           toggle.set(selectedIs());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  45 */           selectedSet(toggle.is());
/*  46 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */       };
/*  49 */     return (CLICKABLE)c;
/*     */   }
/*     */   
/*     */   private static CLICKABLE get(CharSequence name, ACTION action) {
/*  53 */     GButt.Glow glow = new GButt.Glow((UI.FONT()).S.getText(name))
/*     */       {
/*     */         protected void clickA() {
/*  56 */           (VIEW.world()).debug.hide();
/*     */         }
/*     */       };
/*  59 */     glow.clickActionSet(action);
/*  60 */     return (CLICKABLE)glow;
/*     */   }
/*     */   
/*     */   private static void put(CharSequence key, CLICKABLE obj) {
/*  64 */     String s = String.valueOf(key);
/*  65 */     while (hash.containsKey(s))
/*  66 */       s = s + "I"; 
/*  67 */     hash.put(s.toLowerCase(), obj);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void add(CharSequence name, BOOLEAN.BOOLEAN_MUTABLE toggle) {
/*  72 */     put(name, get(name, toggle));
/*     */   }
/*     */   
/*     */   public static void add(CharSequence name, ACTION action) {
/*  76 */     put(name, get(name, action));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void add(final PLACABLE placable) {
/*  82 */     put(placable.name(), get(placable.name(), new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/*  86 */               (VIEW.world()).tools.place(placable);
/*     */             }
/*     */           }));
/*     */   }
/*     */   
/*     */   public static void add(final PLACABLE placable, String prefix) {
/*  92 */     put(placable.name(), get(prefix + " " + prefix, new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/*  96 */               (VIEW.world()).tools.place(placable);
/*     */             }
/*     */           }));
/*     */   }
/*     */   
/*     */   public static void add(final MAP_PLACER placable, String name) {
/* 102 */     add((PLACABLE)new PlacableMulti(name)
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/* 106 */             placable.set(tx, ty);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 113 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void addClear(final MAP_PLACER placable, String name) {
/* 119 */     add((PLACABLE)new PlacableMulti(name)
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 122 */             placable.clear(tx, ty);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 129 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void add(String name, ACTION a) {
/* 135 */     put(name, get(name, a));
/*     */   }
/*     */   
/*     */   public IDebugPanelWorld(InterManager m) {
/* 139 */     super(m, init());
/* 140 */     hash.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   private static TreeMap<CharSequence, CLICKABLE> init() {
/* 145 */     return hash;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\IDebugPanelWorld.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */