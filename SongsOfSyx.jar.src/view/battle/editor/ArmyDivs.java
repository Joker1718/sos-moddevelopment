/*     */ package view.battle.editor;
/*     */ 
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.constant.Config;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GTarget;
/*     */ import util.gui.table.GMatrixDraggable;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.div.UIDivEditor;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupplies;
/*     */ 
/*     */ class ArmyDivs extends GuiSection {
/*  29 */   private ArrayList<RDiv> all = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*     */   
/*     */   private GETTER.GETTER_IMP<ArmySide> current;
/*     */   private final UIDivEditor editor;
/*     */   
/*     */   ArmyDivs(final GETTER.GETTER_IMP<ArmySide> current, UIDivEditor editor) {
/*  35 */     this.editor = editor;
/*  36 */     this.current = current;
/*  37 */     while (this.all.hasRoom()) {
/*  38 */       this.all.add(new RDiv());
/*     */     }
/*     */ 
/*     */     
/*  42 */     GMatrixDraggable m = new GMatrixDraggable(4, 9, (VIEW.UI()).div.normal.width(), (VIEW.UI()).div.normal.height())
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  46 */           return ((ArmySide)current.get()).divs.size();
/*     */         }
/*     */ 
/*     */         
/*     */         public RENDEROBJ get(int i, int columnI) {
/*  51 */           ((ArmyDivs.RDiv)ArmyDivs.this.all.get(i)).div = (DIV_SPEC)((ArmySide)current.get()).divs.get(i);
/*     */           
/*  53 */           return (RENDEROBJ)ArmyDivs.this.all.get(i);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void move(int oldI, int newI) {
/*  59 */           DIV_SPEC after = (DIV_SPEC)((ArmySide)current.get()).divs.get(newI);
/*  60 */           DIV_SPEC dd = (DIV_SPEC)((ArmySide)current.get()).divs.removeOrdered(oldI);
/*  61 */           if (dd == null)
/*     */             return; 
/*  63 */           int ii = ((ArmySide)current.get()).divs.indexOf(after);
/*  64 */           ((ArmySide)current.get()).divs.insert(ii, dd);
/*     */         }
/*     */       };
/*     */     
/*  68 */     add((RENDEROBJ)m);
/*     */     
/*  70 */     GuiSection as = new GuiSection();
/*     */     
/*  72 */     for (ADSupplies.ADArtillery a : AD.supplies().arts()) {
/*     */       
/*  74 */       INT.INTE ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/*  78 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/*  83 */             return 40;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/*  88 */             return ((ArmySide)current.get()).artillery[a.index()];
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/*  93 */             ((ArmySide)current.get()).artillery[a.index()] = t;
/*     */           }
/*     */         };
/*     */       
/*  97 */       GuiSection s = new GuiSection();
/*  98 */       s.hoverInfoSet(a.art.info.names);
/*  99 */       s.add((SPRITE)a.art.icon, 0, 0);
/* 100 */       s.addRightC(8, (RENDEROBJ)new GTarget(48, false, true, ii));
/*     */       
/* 102 */       as.addRightC(16, (RENDEROBJ)s);
/*     */     } 
/*     */ 
/*     */     
/* 106 */     addRelBody(6, DIR.N, (RENDEROBJ)as);
/*     */   }
/*     */ 
/*     */   
/*     */   private class RDiv
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private DIV_SPEC div;
/*     */     private boolean exitHovered;
/*     */     
/*     */     RDiv() {
/* 117 */       this.body.setDim((VIEW.UI()).div.normal.width(), (VIEW.UI()).div.normal.height());
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 122 */       (VIEW.UI()).div.normal.render(r, this.body.x1(), this.body.y1(), 1, this.div, isActive, isSelected, isHovered);
/* 123 */       if (isHovered) {
/* 124 */         if (!this.exitHovered)
/* 125 */           OPACITY.O66.bind(); 
/* 126 */         (UI.icons()).s.cancel.render(r, this.body.x2() - 16, this.body.y1());
/* 127 */         OPACITY.unbind();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 133 */       if (this.exitHovered) {
/* 134 */         ((ArmySide)ArmyDivs.this.current.get()).divs.removeOrdered(this.div);
/*     */       } else {
/* 136 */         ArmyDivs.this.editor.div().copyFrom(this.div);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 141 */       if (this.exitHovered) {
/* 142 */         text.title(Dic.¤¤remove);
/* 143 */         text.text(Dic.¤¤RightClick);
/*     */       } else {
/* 145 */         (VIEW.UI()).div.normal.hover(this.div, text);
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 150 */       this.exitHovered = false;
/* 151 */       if (super.hover(mCoo)) {
/* 152 */         if (mCoo.isWithin(this.body.x2() - 16, this.body.x2(), this.body.y1(), this.body.y1() + 16))
/* 153 */           this.exitHovered = true; 
/* 154 */         if (MButt.RIGHT.consumeClick())
/* 155 */           ((ArmySide)ArmyDivs.this.current.get()).divs.removeOrdered(this.div); 
/* 156 */         return true;
/*     */       } 
/* 158 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\ArmyDivs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */