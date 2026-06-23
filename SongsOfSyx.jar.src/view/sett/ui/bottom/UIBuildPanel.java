/*     */ package view.sett.ui.bottom;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.keyboard.KeyPage;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.construction.UIRoomPlacer;
/*     */ import view.tool.PLACABLE;
/*     */ 
/*     */ public final class UIBuildPanel extends Interrupter {
/*  31 */   private final GuiSection section = new GuiSection();
/*     */   private SearchToolPanel searchPanel;
/*     */   private BuildMain main;
/*     */   private final UIRoomPlacer placer;
/*     */   
/*     */   public UIBuildPanel(UIRoomPlacer placer, InterManager m) {
/*  37 */     pin();
/*  38 */     m.add(this);
/*  39 */     this.placer = placer;
/*  40 */     SearchToolPanel.all = new LinkedList();
/*  41 */     SETT.addGeneratorHook(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  45 */             SearchToolPanel.all = new LinkedList();
/*  46 */             UIBuildPanel.this.create();
/*     */           }
/*     */         });
/*  49 */     create();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void create() {
/*  56 */     this.section.clear();
/*  57 */     this.section.add(SPRITES.specials().lowerPanel(), 0, 0);
/*     */     
/*  59 */     this.section.body().centerX(0.0D, C.WIDTH());
/*  60 */     this.section.body().moveY2(C.HEIGHT());
/*     */     
/*  62 */     GuiSection s = new GuiSection();
/*  63 */     D.gInit(this);
/*     */ 
/*     */     
/*  66 */     final Inter inter = new Inter();
/*     */ 
/*     */     
/*  69 */     final GButt.ButtPanel c = new GButt.ButtPanel((SPRITE)new SPRITE.Wrap((SPRITE)(SPRITES.icons()).m.search, 32, 32));
/*  70 */     ACTION sa = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  74 */           UIBuildPanel.this.searchPanel.open(c, inter);
/*     */         }
/*     */       };
/*     */     
/*  78 */     buttPanel1.clickActionSet(sa);
/*  79 */     CLICKABLE cc = KeyButt.wrap(sa, (CLICKABLE)buttPanel1, (KeyPage)KEYS.SETT(), "toolSearch", D.g("Search"), D.g("SearchD", "Search for tools and rooms"), 341, 70);
/*  80 */     s.addRightC(8, (RENDEROBJ)cc);
/*     */     
/*  82 */     this.main = new BuildMain(inter, this.placer);
/*  83 */     s.addRightC(8, (RENDEROBJ)this.main.create());
/*     */ 
/*     */     
/*  86 */     final Options sec = new Options();
/*     */ 
/*     */     
/*  89 */     GButt.ButtPanel buttPanel3 = new GButt.ButtPanel((SPRITE)new SPRITE.Wrap((SPRITE)(SPRITES.icons()).m.cog_big, 32, 32))
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  93 */           inter.set((CLICKABLE)this, (CLICKABLE)sec);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  98 */           selectedSet((SETT.JOBS()).planMode.is());
/*     */         }
/*     */       };
/*     */     
/* 102 */     buttPanel3.hoverTitleSet(Dic.¤¤Tools);
/* 103 */     s.addRightC(0, (RENDEROBJ)buttPanel3);
/*     */ 
/*     */ 
/*     */     
/* 107 */     final Delete delete = new Delete();
/* 108 */     GButt.ButtPanel buttPanel2 = new GButt.ButtPanel((SPRITE)new SPRITE.Wrap((SPRITE)(SPRITES.icons()).m.cancel, 32, 32))
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 112 */           inter.set((CLICKABLE)this, (CLICKABLE)delete);
/*     */         }
/*     */       };
/*     */     
/* 116 */     buttPanel2.hoverTitleSet(Dic.¤¤delete);
/* 117 */     s.addRightC(0, (RENDEROBJ)buttPanel2);
/*     */ 
/*     */ 
/*     */     
/* 121 */     s.body().centerIn((BODY_HOLDER)this.section);
/* 122 */     s.body().incrY(4.0D);
/* 123 */     this.section.add((RENDEROBJ)s);
/*     */     
/* 125 */     this.searchPanel = new SearchToolPanel();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 130 */     return this.section.hover(mCoo);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 135 */     if (button == MButt.LEFT) {
/* 136 */       this.section.click();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 142 */     this.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 148 */     this.section.render((SPRITE_RENDERER)r, ds);
/*     */     
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hilight(String key) {
/* 155 */     this.main.hilight(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 162 */     return true;
/*     */   }
/*     */   
/*     */   protected static class Butt
/*     */     extends GButt.ButtPanel {
/*     */     private final PLACABLE p;
/*     */     
/*     */     Butt(PLACABLE p) {
/* 170 */       super(p.getIcon());
/* 171 */       this.p = p;
/*     */     }
/*     */     
/*     */     Butt(PLACABLE p, Icon icon) {
/* 175 */       super(p.getIcon());
/* 176 */       this.p = p;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 181 */       this.p.hoverDesc((GBox)text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 186 */       (VIEW.s()).tools.place(this.p);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 191 */       selectedSet((this.p == (VIEW.s()).tools.placer.getCurrent()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\UIBuildPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */