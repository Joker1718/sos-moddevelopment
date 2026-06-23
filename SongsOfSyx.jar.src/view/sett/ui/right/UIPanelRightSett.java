/*     */ package view.sett.ui.right;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.minimap.UIMinimapSett;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ public class UIPanelRightSett extends Interrupter implements SAVABLE {
/*  30 */   private static CharSequence ¤¤hotspots = "Hot-spots";
/*  31 */   private static CharSequence ¤¤minipanels = "Mini Panels"; final UIMiniResources resources; final UIMiniHotSpots hs; final UIMiniRaces species; private final Expansion[] all; private boolean[] visable;
/*     */   static {
/*  33 */     D.ts(UIPanelRightSett.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  41 */   private int[] widths = Alloc.ii(4);
/*     */   
/*     */   public UIPanelRightSett(UIMinimapSett top, InterManager i, GameWindow w) {
/*  44 */     desturberSet().persistantSet().pin();
/*     */     
/*  46 */     int y1 = top.y2();
/*     */ 
/*     */ 
/*     */     
/*  50 */     this.resources = new UIMiniResources(1, y1);
/*  51 */     this.hs = new UIMiniHotSpots(2, y1, w);
/*  52 */     this.species = new UIMiniRaces(3, y1);
/*     */ 
/*     */     
/*  55 */     this.all = new Expansion[] {
/*  56 */         this.species, 
/*  57 */         this.resources, 
/*  58 */         this.hs
/*     */       };
/*  60 */     this.visable = new boolean[4];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     this.hs.visableSet(true);
/*  68 */     this.resources.visableSet(true);
/*  69 */     this.species.visableSet(true);
/*     */ 
/*     */ 
/*     */     
/*  73 */     update(0.0F);
/*  74 */     show(i);
/*     */     
/*  76 */     top.panel().padd(makeButt());
/*     */   }
/*     */   
/*     */   private CLICKABLE makeButt() {
/*  80 */     final GuiSection s = new GuiSection();
/*  81 */     s.addDownC(0, exp(this.species, (HCLASSES.CITIZEN()).names));
/*  82 */     s.addDownC(0, exp(this.resources, Dic.¤¤Resource));
/*  83 */     s.addDownC(0, exp(this.hs, ¤¤hotspots));
/*     */ 
/*     */     
/*  86 */     CLICKABLE c = (new UIMinimapSett.Butt((SPRITE)(SPRITES.icons()).s.menu)
/*     */       {
/*     */         protected void clickA() {
/*  89 */           (VIEW.inters()).popup.show((RENDEROBJ)s, (CLICKABLE)this);
/*     */         }
/*  91 */       }).hoverInfoSet(¤¤minipanels);
/*  92 */     return c;
/*     */   } protected void hoverTimer(GBox text) {
/*     */     byte b;
/*     */     int i;
/*     */     Expansion[] arrayOfExpansion;
/*  97 */     for (i = (arrayOfExpansion = this.all).length, b = 0; b < i; ) { Expansion e = arrayOfExpansion[b];
/*  98 */       e.hoverInfoGet((GUI_BOX)text);
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 105 */     int w = 0; byte b; int i; Expansion[] arrayOfExpansion;
/* 106 */     for (i = (arrayOfExpansion = this.all).length, b = 0; b < i; ) { Expansion e = arrayOfExpansion[b];
/* 107 */       if (e.visableIs()) {
/* 108 */         w += e.body().width();
/* 109 */         e.render((SPRITE_RENDERER)r, ds);
/*     */       } 
/*     */       
/*     */       b++; }
/*     */     
/* 114 */     if (w > 0) {
/* 115 */       manager().viewPort().incrW(-w);
/*     */     }
/* 117 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 125 */     this.hs.click();
/* 126 */     if (button == MButt.LEFT) {
/* 127 */       byte b; int i; Expansion[] arrayOfExpansion; for (i = (arrayOfExpansion = this.all).length, b = 0; b < i; ) { Expansion e = arrayOfExpansion[b];
/* 128 */         e.click();
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 137 */     boolean h = false; byte b; int i; Expansion[] arrayOfExpansion;
/* 138 */     for (i = (arrayOfExpansion = this.all).length, b = 0; b < i; ) { Expansion e = arrayOfExpansion[b];
/*     */       
/* 140 */       if (e.hover(mCoo))
/* 141 */         h = true; 
/*     */       b++; }
/*     */     
/* 144 */     return h;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 149 */     boolean changed = false;
/* 150 */     int i = 0; byte b; int j; Expansion[] arrayOfExpansion;
/* 151 */     for (j = (arrayOfExpansion = this.all).length, b = 0; b < j; ) { Expansion expansion = arrayOfExpansion[b];
/* 152 */       if (expansion.visableIs() != this.visable[i]) {
/* 153 */         changed = true;
/* 154 */         this.visable[i] = expansion.visableIs();
/*     */       } 
/* 156 */       if (this.widths[i] != expansion.body().width()) {
/* 157 */         this.widths[i] = expansion.body().width();
/* 158 */         changed = true;
/*     */       } 
/* 160 */       i++;
/*     */       b++; }
/*     */     
/* 163 */     if (changed) {
/* 164 */       int x2 = C.WIDTH();
/* 165 */       for (i = this.all.length - 1; i >= 0; i--) {
/* 166 */         if (this.all[i].visableIs()) {
/* 167 */           this.all[i].body().moveX2(x2);
/* 168 */           x2 = this.all[i].body().x1();
/*     */         } 
/*     */       } 
/*     */     } 
/* 172 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 177 */     int i = 0; byte b; int j; Expansion[] arrayOfExpansion;
/* 178 */     for (j = (arrayOfExpansion = this.all).length, b = 0; b < j; ) { Expansion expansion = arrayOfExpansion[b];
/* 179 */       i |= expansion.visableIs() ? 1 : 0;
/* 180 */       i <<= 1; b++; }
/*     */     
/* 182 */     file.i(i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 188 */     int i = file.i();
/* 189 */     int k = this.all.length; byte b; int j; Expansion[] arrayOfExpansion;
/* 190 */     for (j = (arrayOfExpansion = this.all).length, b = 0; b < j; ) { Expansion expansion = arrayOfExpansion[b];
/* 191 */       expansion.visableSet(((i >> k & 0x1) == 1));
/* 192 */       k--;
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 200 */     for (int i = 0; i < this.visable.length; i++)
/* 201 */       this.visable[i] = true; 
/* 202 */     this.hs.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static abstract class Expansion
/*     */     extends GuiSection
/*     */   {
/*     */     Expansion(int index) {}
/*     */   }
/*     */ 
/*     */   
/*     */   private RENDEROBJ exp(final Expansion s, CharSequence name) {
/* 215 */     if (s == null) {
/* 216 */       throw new RuntimeException();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 227 */     return (RENDEROBJ)(new GButt.ButtPanel(name) { protected void clickA() { s.visableSet(!s.visableIs()); } protected void renAction() { selectedSet(s.visableIs()); } }).setDim(140, 32);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIPanelRightSett.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */