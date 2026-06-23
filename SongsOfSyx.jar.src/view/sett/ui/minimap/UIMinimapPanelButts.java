/*     */ package view.sett.ui.minimap;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Comparator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import snake2d.CORE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.SUPER_SCREENSHOT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.SuperSc;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.keyboard.KeyPage;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ public class UIMinimapPanelButts
/*     */ {
/*  37 */   final GuiSection section = new GuiSection()
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, float ds) {
/*  40 */         (GCOLOR.UI()).panBG.render(r, (RECTANGLE)body());
/*  41 */         super.render(r, ds);
/*  42 */         GCOLOR.UI().borderH(r, (RECTANGLE)body(), 0);
/*     */       }
/*     */     };
/*  45 */   private final GuiSection pbuttons = new GuiSection();
/*     */   
/*  47 */   private static CharSequence ¤¤HideUI = "¤Cinematic mode + Hide UI. Cancel by right click or ESC.";
/*  48 */   private static CharSequence ¤¤ToggleOverlay = "¤Toggle Overlay: ";
/*     */   
/*     */   static {
/*  51 */     D.ts(UIMinimapPanelButts.class);
/*     */   }
/*     */   
/*     */   UIMinimapPanelButts(final UIMiniMapSettView view, UIMinimapPanel panel, final GameWindow w) {
/*  55 */     this.section.body().setDim(panel.body().width(), 36.0D);
/*  56 */     this.pbuttons.body().centerIn((RECTANGLE)this.section.body());
/*  57 */     this.section.add((RENDEROBJ)this.pbuttons);
/*  58 */     this.section.body().moveX2(C.WIDTH());
/*  59 */     this.section.body().moveY1(panel.body().y2());
/*     */ 
/*     */ 
/*     */     
/*  63 */     UIMinimapSett.Butt butt = new UIMinimapSett.Butt((SPRITE)(SPRITES.icons()).s.minimap)
/*     */       {
/*     */         protected void clickA() {
/*  66 */           view.show();
/*     */         }
/*     */       };
/*  69 */     padd(KeyButt.wrap((CLICKABLE)butt, (KEYS.MAIN()).MINIMAP));
/*     */     
/*  71 */     butt = new UIMinimapSett.Butt((SPRITE)(SPRITES.icons()).s.minifier)
/*     */       {
/*     */         protected void clickA() {
/*  74 */           if (w.zoomout() < w.zoomoutmax()) {
/*  75 */             w.setZoomout(w.zoomout() + 1);
/*     */           }
/*     */         }
/*     */         
/*     */         protected void renAction() {
/*  80 */           activeSet((w.zoomout() < w.zoomoutmax()));
/*     */         }
/*     */       };
/*  83 */     padd(KeyButt.wrap((CLICKABLE)butt, (KEYS.MAIN()).ZOOM_OUT));
/*     */     
/*  85 */     butt = new UIMinimapSett.Butt((SPRITE)(SPRITES.icons()).s.magnifier)
/*     */       {
/*     */         protected void clickA() {
/*  88 */           if (w.zoomout() > 0)
/*  89 */             w.setZoomout(w.zoomout() - 1); 
/*     */         }
/*     */         
/*     */         protected void renAction() {
/*  93 */           activeSet((w.zoomout() > 0));
/*     */         }
/*     */       };
/*  96 */     padd(KeyButt.wrap((CLICKABLE)butt, (KEYS.MAIN()).ZOOM_IN));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addScreenshot(String savekey) {
/* 108 */     UIMinimapSett.Butt butt = new UIMinimapSett.Butt((SPRITE)(SPRITES.icons()).s.camera)
/*     */       {
/*     */         protected void clickA() {
/* 111 */           CORE.getGraphics().makeScreenShot();
/*     */         }
/*     */       };
/*     */     
/* 115 */     padd(KeyButt.wrap((CLICKABLE)butt, (KEYS.MAIN()).SCREENSHOT));
/*     */     
/* 117 */     butt = new UIMinimapSett.Butt((SPRITE)(SPRITES.icons()).s.cameraBig, savekey)
/*     */       {
/*     */         private final SuperSc sst;
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 124 */           (VIEW.inters()).popup.show((RENDEROBJ)this.sst, (CLICKABLE)this, true);
/*     */         }
/*     */       };
/* 127 */     butt.hoverInfoSet(SuperSc.¤¤name);
/* 128 */     padd((CLICKABLE)butt);
/*     */     
/* 130 */     butt = new UIMinimapSett.Butt((SPRITE)(SPRITES.icons()).s.cancel)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 134 */           VIEW.hide();
/*     */         }
/*     */       };
/* 137 */     butt.hoverInfoSet(¤¤HideUI);
/* 138 */     padd((CLICKABLE)butt);
/*     */   }
/*     */   
/*     */   public GETTER.GETTER_IMP<Addable> addOverlays() {
/* 142 */     final GuiSection s = new GuiSection();
/*     */     
/* 144 */     final GETTER.GETTER_IMP<Addable> thing = new GETTER.GETTER_IMP();
/*     */     
/* 146 */     int i = 0;
/* 147 */     ArrayList<Addable> aa = new ArrayList((Iterable)SETT.OVERLAY().all());
/* 148 */     aa.sort(new Comparator<Addable>()
/*     */         {
/*     */           public int compare(Addable arg0, Addable arg1)
/*     */           {
/* 152 */             return String.valueOf(arg0.name).compareTo(String.valueOf(arg1.name));
/*     */           }
/*     */         });
/* 155 */     for (Addable a : aa) {
/* 156 */       if (a.key != null) {
/* 157 */         CLICKABLE cc = ontop(a, thing);
/* 158 */         s.add((RENDEROBJ)cc, i % 2 * cc.body().width(), i / 2 * cc.body().height());
/* 159 */         i++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 165 */     CLICKABLE c = (new UIMinimapSett.Butt((SPRITE)(SPRITES.icons()).s.eye)
/*     */       {
/*     */         protected void clickA() {
/* 168 */           (VIEW.inters()).popup.show((RENDEROBJ)s, (CLICKABLE)this);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 173 */           if (hoveredIs() && MButt.RIGHT.consumeClick()) {
/* 174 */             thing.set(null);
/*     */           }
/*     */           
/* 177 */           if (thing.get() != null) {
/* 178 */             ((Addable)thing.get()).add();
/*     */           }
/*     */           
/* 181 */           selectedSet((thing.get() != null));
/*     */         }
/* 183 */       }).hoverInfoSet(Dic.¤¤Overlays);
/*     */     
/* 185 */     padd(c);
/* 186 */     return thing;
/*     */   }
/*     */   
/*     */   private CLICKABLE ontop(final Addable add, final GETTER.GETTER_IMP<Addable> thing) {
/* 190 */     final ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 194 */           if (thing.get() == add) {
/* 195 */             thing.set(null);
/*     */           } else {
/* 197 */             thing.set(add);
/*     */           } 
/*     */         }
/*     */       };
/* 201 */     GButt.ButtPanel c = new GButt.ButtPanel((UI.FONT()).H2.getText(add.name))
/*     */       {
/*     */         protected void clickA() {
/* 204 */           a.exe();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 209 */           selectedSet((thing.get() == add));
/*     */         }
/*     */       };
/*     */     
/* 213 */     c.setDim(250, 30).align(DIR.W).hoverTitleSet(add.name).hoverInfoSet(add.desc);
/* 214 */     c.icon(add.icon.resized(32));
/*     */     
/* 216 */     if (add == (SETT.OVERLAY()).ROOM_PROBLEM) {
/* 217 */       return KeyButt.wrap(a, (CLICKABLE)c, (KeyPage)KEYS.SETT(), "TOGGLE_OVERLAY_" + add.key, add.name, String.valueOf(¤¤ToggleOverlay) + " " + String.valueOf(¤¤ToggleOverlay), 32, -1);
/*     */     }
/*     */     
/* 220 */     return KeyButt.wrap(a, (CLICKABLE)c, (KeyPage)KEYS.SETT(), "TOGGLE_OVERLAY_" + add.key, add.name, String.valueOf(¤¤ToggleOverlay) + " " + String.valueOf(¤¤ToggleOverlay));
/*     */   }
/*     */   
/*     */   private static class Shot
/*     */     extends SUPER_SCREENSHOT {
/*     */     private final int zoomout;
/*     */     private final int winW;
/*     */     private final int winH;
/*     */     private Rec current;
/*     */     
/*     */     Shot(int scale, int zoomout) {
/* 231 */       super(scale);
/* 232 */       this.zoomout = zoomout;
/* 233 */       this.winW = C.WIDTH() << zoomout;
/* 234 */       this.winH = C.HEIGHT() << zoomout;
/* 235 */       this.current = new Rec(this.winW, this.winH);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean renderAndHasNext() {
/* 241 */       if (this.current.y1() >= SETT.PHEIGHT) {
/* 242 */         return false;
/*     */       }
/* 244 */       GAME.s().render(CORE.renderer(), 0.0F, this.zoomout, (RECTANGLE)this.current, 0, 0, UIMinimapSettConfig.NORMAL);
/* 245 */       this.current.incrX(this.winW);
/* 246 */       if (this.current.x1() >= SETT.PWIDTH) {
/* 247 */         this.current.incrY(this.winH);
/* 248 */         this.current.moveX1(0.0D);
/*     */       } 
/* 250 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getWidth() {
/* 255 */       return SETT.PWIDTH >> this.zoomout;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getHeight() {
/* 260 */       return SETT.PHEIGHT >> this.zoomout;
/*     */     }
/*     */ 
/*     */     
/*     */     public void init() {
/* 265 */       this.current.set(0.0D, this.winW, 0.0D, this.winH);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void padd(CLICKABLE cl) {
/* 273 */     this.pbuttons.addRelBody(0, DIR.W, (RENDEROBJ)cl);
/* 274 */     this.pbuttons.body().moveX1((this.section.body().x1() + 4));
/* 275 */     this.pbuttons.body().moveCY(this.section.body().cY());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapPanelButts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */