/*     */ package view.ui.family;
/*     */ import init.constant.C;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInputInt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.info.GFORMAT;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class UIFamilyTree extends Interrupter {
/*     */   static final int MAX_REFS = 2048;
/*  31 */   private final UIFamilyTreeRefs refs = new UIFamilyTreeRefs(); private boolean remove = false;
/*  32 */   private final UIFamilyTreeAligner aligner = new UIFamilyTreeAligner();
/*  33 */   private final UIFamilyTreeDrawer drawer = new UIFamilyTreeDrawer();
/*     */   
/*  35 */   private final GuiSection buttons = new GuiSection();
/*     */ 
/*     */ 
/*     */   
/*     */   private int currentRef;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIFamilyTree() {
/*  45 */     if ((S.get()).developer) {
/*     */       
/*  47 */       this.buttons.addRightC(0, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  51 */               int am = 0;
/*  52 */               for (int i = 0; i < STATS.REL().references(); i++) {
/*  53 */                 if (STATS.REL().isRef(i))
/*  54 */                   am++; 
/*  55 */               }  GFORMAT.iofk(text, am, STATS.REL().references());
/*     */             }
/*     */           });
/*     */       
/*  59 */       INT.INTE ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/*  63 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/*  68 */             return 300;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/*  73 */             return UIFamilyTree.this.aligner.maxIterations;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/*  78 */             UIFamilyTree.this.aligner.maxIterations = t;
/*  79 */             UIFamilyTree.this.init(UIFamilyTree.this.currentRef);
/*     */           }
/*     */         };
/*  82 */       this.buttons.addRightC(100, (RENDEROBJ)new GInputInt(ii, true, true));
/*     */       
/*  84 */       this.buttons.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.plus)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/*  88 */               STATS.REL().debugPopulate();
/*  89 */               UIFamilyTree.this.init(UIFamilyTree.this.currentRef);
/*     */             }
/*  92 */           }).hoverInfoSet("populate"));
/*  93 */       this.buttons.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.cancel)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/*  97 */               UIFamilyTree.this.remove = !UIFamilyTree.this.remove;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 102 */               selectedSet(UIFamilyTree.this.remove);
/*     */             }
/* 105 */           }).hoverInfoSet("toggleRemove"));
/* 106 */       this.buttons.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.disease)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 110 */               STATS.REL().debugPrune();
/* 111 */               UIFamilyTree.this.init(UIFamilyTree.this.currentRef);
/*     */             }
/* 114 */           }).hoverInfoSet("prune"));
/*     */     } 
/*     */     
/* 117 */     this.buttons.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.exit)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 121 */             UIFamilyTree.this.hide();
/*     */           }
/* 124 */         }).hoverInfoSet(Dic.¤¤Close));
/*     */     
/* 126 */     GPanel p = new GPanel((RECTANGLE)this.buttons.body());
/* 127 */     p.setButt();
/* 128 */     this.buttons.add((RENDEROBJ)p);
/* 129 */     this.buttons.moveLastToBack();
/*     */     
/* 131 */     this.buttons.body().moveX2((C.WIDTH() - 20));
/* 132 */     this.buttons.body().moveY1(20.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void show(Induvidual indu) {
/* 138 */     show(STATS.REL().reference(indu));
/*     */   }
/*     */ 
/*     */   
/*     */   public void show(int ref) {
/* 143 */     if (STATS.REL().isRef(ref)) {
/* 144 */       init(ref);
/* 145 */       show((VIEW.inters()).manager);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void init(int ref) {
/* 151 */     if (STATS.REL().isRef(ref)) {
/* 152 */       this.refs.init(ref);
/* 153 */       this.aligner.init(this.refs);
/* 154 */       this.drawer.init(ref, this.refs, this.aligner);
/* 155 */       this.currentRef = ref;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 162 */     this.buttons.hover(mCoo);
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 168 */     if (button == MButt.RIGHT) {
/* 169 */       hide();
/* 170 */     } else if (button == MButt.LEFT) {
/* 171 */       if (this.buttons.hoveredIs()) {
/* 172 */         this.buttons.click();
/*     */       } else {
/* 174 */         int hovered = this.drawer.hovered();
/* 175 */         if (!STATS.REL().isRef(hovered)) {
/* 176 */           this.drawer.drag();
/* 177 */         } else if (this.remove) {
/* 178 */           if (hovered == this.currentRef) {
/* 179 */             for (int i = 0; i < this.refs.max(); i++) {
/* 180 */               if (this.refs.get(i) != hovered) {
/* 181 */                 STATS.REL().removeRef(hovered);
/* 182 */                 init(this.refs.get(i));
/*     */               } 
/*     */             } 
/*     */             return;
/*     */           } 
/* 187 */           STATS.REL().removeRef(hovered);
/* 188 */           init(this.currentRef);
/*     */         }
/* 190 */         else if (hovered == this.currentRef && STATS.REL().human(hovered) != null) {
/* 191 */           Humanoid h = STATS.REL().human(hovered);
/*     */           
/* 193 */           hide();
/* 194 */           VIEW.s().activate();
/* 195 */           if ((VIEW.s()).ui.subjects.canShow(h)) {
/* 196 */             (VIEW.s()).ui.subjects.show(h);
/*     */           } else {
/* 198 */             VIEW.s().getWindow().centerAt(h.body().cX(), h.body().cY());
/*     */           } 
/*     */         } else {
/* 201 */           init(hovered);
/*     */         } 
/*     */       } 
/*     */     } 
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
/*     */   protected void hoverTimer(GBox text) {
/* 216 */     if (this.buttons.hoveredIs()) {
/* 217 */       this.buttons.hoverInfoGet((GUI_BOX)text);
/*     */     } else {
/*     */       
/* 220 */       STATS.REL().hover((GUI_BOX)text, this.drawer.hovered());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 230 */     this.drawer.draw(ds, this.refs, this.aligner, this.currentRef);
/*     */     
/* 232 */     this.buttons.render((SPRITE_RENDERER)r, ds);
/* 233 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 238 */     if (!STATS.REL().isRef(this.currentRef))
/* 239 */       hide(); 
/* 240 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\family\UIFamilyTree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */