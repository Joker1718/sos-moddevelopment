/*     */ package menu;
/*     */ 
/*     */ import init.settings.S;
/*     */ import java.util.LinkedList;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.D;
/*     */ import view.menu.MenuScreen;
/*     */ 
/*     */ 
/*     */ final class ScOptions
/*     */   extends GUI.Shadower
/*     */   implements SC
/*     */ {
/*  22 */   private final LinkedList<Option> options = new LinkedList<>();
/*     */   
/*     */   private final CLICKABLE revert;
/*  25 */   static CharSequence ¤¤name = "¤settings";
/*  26 */   static CharSequence ¤¤revert = "¤revert";
/*  27 */   static CharSequence ¤¤default = "¤restore";
/*     */   
/*     */   static {
/*  30 */     D.ts(ScOptions.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   ScOptions(final Menu menu) {
/*  36 */     MenuScreen screen = new MenuScreen(¤¤name, GUI.labelColor)
/*     */       {
/*     */         protected void back()
/*     */         {
/*  40 */           menu.switchScreen(menu.main);
/*     */         }
/*     */       };
/*     */     
/*  44 */     this.revert = (CLICKABLE)new MenuScreen.ScreenButton(¤¤revert)
/*     */       {
/*     */         protected void clickA() {
/*  47 */           ScOptions.this.revert();
/*     */         }
/*     */       };
/*     */     
/*  51 */     screen.addButt((RENDEROBJ)this.revert);
/*     */     
/*  53 */     add((RENDEROBJ)screen);
/*     */     
/*  55 */     GuiSection keys = new GuiSection()
/*     */       {
/*     */         public boolean click() {
/*  58 */           if (super.click()) {
/*  59 */             ScOptions.this.revert.activeSet(true);
/*     */           }
/*  61 */           return false;
/*     */         }
/*     */       };
/*  64 */     keys.body().moveY1(GUI.left.y1());
/*  65 */     int x1 = 0;
/*     */     
/*  67 */     for (S.Setting s : S.get().all()) {
/*     */       
/*  69 */       Option kc = new Option(s);
/*  70 */       if (keys.getLastY2() > GUI.left.y2()) {
/*  71 */         x1 = (int)(x1 + (GUI.margin * 2) + GUI.margin * 0.2D);
/*  72 */         kc.body().moveY1(keys.body().y1());
/*     */       } else {
/*  74 */         kc.body().moveY1(keys.getLastY2());
/*     */       } 
/*  76 */       kc.body().moveX2(x1);
/*  77 */       keys.add((RENDEROBJ)kc);
/*     */     } 
/*  79 */     keys.body().centerIn(GUI.bounds);
/*     */     
/*  81 */     keys.body().centerIn((BODY_HOLDER)this);
/*     */     
/*  83 */     add((RENDEROBJ)keys);
/*     */   }
/*     */ 
/*     */   
/*     */   void make(S.Setting s, CharSequence name, GuiSection keys, int i) {}
/*     */ 
/*     */   
/*     */   private class Option
/*     */     extends GUI.OptionLine
/*     */   {
/*     */     private final S.Setting sett;
/*     */     
/*     */     protected Option(S.Setting s) {
/*  96 */       super((INT.INTE)s, s.name);
/*  97 */       this.sett = s;
/*  98 */       ScOptions.this.options.add(this);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void setValue(GText str) {
/* 103 */       this.sett.getValue((Str)str);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean click() {
/* 108 */       if (super.click()) {
/* 109 */         S.get().applyRuntimeConfigs();
/* 110 */         return true;
/*     */       } 
/* 112 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void revert() {
/* 118 */     S.get().revert();
/* 119 */     S.get().applyRuntimeConfigs();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean back(Menu menu) {
/* 129 */     menu.switchScreen(menu.main);
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScOptions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */