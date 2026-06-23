/*     */ package view.interrupter;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.TreeMap;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.data.BOOLEAN;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
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
/*     */ public class IDebugPanel
/*     */   extends IDebugPanelAbs
/*     */ {
/*  29 */   private static final TreeMap<CharSequence, CLICKABLE> hash = new TreeMap<>();
/*     */   
/*     */   private static CLICKABLE get(String name, final BOOLEAN.BOOLEAN_MUTABLE toggle) {
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
/*     */   private static CLICKABLE get(String name, ACTION action) {
/*  49 */     GButt.Glow glow = new GButt.Glow((UI.FONT()).S.getText(name))
/*     */       {
/*     */         protected void clickA() {
/*  52 */           (VIEW.inters()).debugpanel.hide();
/*     */         }
/*     */       };
/*  55 */     glow.clickActionSet(action);
/*  56 */     return (CLICKABLE)glow;
/*     */   }
/*     */   
/*     */   private static void put(String key, CLICKABLE obj) {
/*  60 */     while (hash.containsKey(key))
/*  61 */       key = key + "I"; 
/*  62 */     hash.put(key.toLowerCase(), obj);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void add(String name, BOOLEAN.BOOLEAN_MUTABLE toggle) {
/*  67 */     put(name, get(name, toggle));
/*     */   }
/*     */   
/*     */   public static void add(String name, ACTION a) {
/*  71 */     put(name, get(name, a));
/*     */   }
/*     */   
/*     */   public IDebugPanel(InterManager manager) {
/*  75 */     super(addStaticStuff(manager), hash);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addMisc() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static InterManager addStaticStuff(InterManager manager) {
/*  91 */     add("show stats", new BOOLEAN.BOOLEAN_MUTABLE()
/*     */         {
/*     */ 
/*     */           
/*     */           public BOOLEAN.BOOLEAN_MUTABLE set(boolean bool)
/*     */           {
/*  97 */             GUTIL.debugger().toggle();
/*  98 */             return this;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean is() {
/* 103 */             return GUTIL.debugger().isToggled();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 108 */     add("crash", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 112 */             throw new RuntimeException("Crash");
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 118 */     add("hideUI(cancel with esc)", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 122 */             VIEW.hide();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 127 */     add("garbage Collect", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 131 */             (new CORE.GlJob()
/*     */               {
/*     */                 protected void doJob()
/*     */                 {
/* 135 */                   gc();
/*     */                 }
/* 137 */               }).perform();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     return manager;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IDebugPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */