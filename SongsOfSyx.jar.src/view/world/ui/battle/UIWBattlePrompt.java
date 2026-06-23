/*     */ package view.world.ui.battle;
/*     */ import init.constant.C;
/*     */ import snake2d.LOG;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.panel.GPanel;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ import world.battle.spec.WBattleResult;
/*     */ import world.battle.spec.WBattleSiege;
/*     */ import world.battle.spec.WBattleSpec;
/*     */ 
/*     */ public class UIWBattlePrompt {
/*  21 */   private final Inter inter = new Inter();
/*  22 */   private final Battle battleBattle = new BattleBattle(this.inter);
/*  23 */   private final Battle battleAssist = new BattleAssist(this.inter);
/*  24 */   private final Battle battleLastStand = new BattleLastStand(this.inter);
/*  25 */   private final Battle battleSally = new BattleSally(this.inter);
/*  26 */   private final BattleSiege siege = new BattleSiege(this.inter);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBusty() {
/*  33 */     return this.inter.isActivated();
/*     */   }
/*     */   
/*     */   public void battle(WBattleSpec battle) {
/*  37 */     prompt(battle, this.battleBattle);
/*     */   }
/*     */   
/*     */   public void assist(WBattleSpec battle) {
/*  41 */     prompt(battle, this.battleAssist);
/*     */   }
/*     */   
/*     */   public void lastStand(WBattleSpec battle) {
/*  45 */     prompt(battle, this.battleLastStand);
/*     */   }
/*     */   
/*     */   public void battleSally(WBattleSpec battle) {
/*  49 */     prompt(battle, this.battleSally);
/*     */   }
/*     */   
/*     */   private void prompt(WBattleSpec battle, Battle b) {
/*  53 */     if (this.inter.isActivated()) {
/*  54 */       LOG.err("Oh no!");
/*     */       
/*     */       return;
/*     */     } 
/*  58 */     b.get(battle);
/*     */ 
/*     */     
/*  61 */     this.inter.set(b.get(battle), true, battle.player.coo().x(), battle.player.coo().y());
/*     */   }
/*     */   
/*     */   public void siege(WBattleSiege siege) {
/*  65 */     if (this.inter.isActivated()) {
/*  66 */       LOG.err("Oh no!");
/*     */       return;
/*     */     } 
/*  69 */     this.inter.set(this.siege.getS(siege), true, siege.besiged.cx(), siege.besiged.cy());
/*     */   }
/*     */ 
/*     */   
/*     */   public void result(WBattleSiege.Result siege) {
/*  74 */     this.inter.set(new Conquer(this.inter, siege), false, siege.besiged.cx(), siege.besiged.cy());
/*     */   }
/*     */   
/*     */   public void result(WBattleResult battle, boolean retreat) {
/*  78 */     this.inter.set(new Res(this.inter, battle, retreat), false, battle.player.coo().x(), battle.player.coo().y());
/*     */   }
/*     */   
/*     */   private static class Inter
/*     */     extends Interrupter implements ACTION {
/*     */     private GuiSection s;
/*     */     private boolean canSave;
/*  85 */     private final GPanel panel = new GPanel();
/*     */     
/*     */     Inter() {
/*  88 */       pin();
/*  89 */       persistantSet();
/*  90 */       this.panel.setBig();
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/*  95 */       this.s.hover(mCoo);
/*  96 */       this.panel.hover(mCoo);
/*  97 */       return true;
/*     */     }
/*     */     
/*     */     void set(GuiSection s, boolean canSave, int cx, int cy) {
/* 101 */       if (isActivated()) {
/* 102 */         throw new RuntimeException();
/*     */       }
/* 104 */       (VIEW.world()).uiManager.clear();
/* 105 */       (VIEW.world()).panels.clear();
/* 106 */       this.s = s;
/* 107 */       this.canSave = canSave;
/* 108 */       this.panel.inner().set((BODY_HOLDER)s);
/* 109 */       this.panel.inner().centerIn(C.DIM());
/* 110 */       this.panel.inner().moveY2((C.HEIGHT() - 100));
/*     */       
/* 112 */       s.body().centerIn((RECTANGLE)this.panel.inner());
/* 113 */       VIEW.world().activate();
/* 114 */       (VIEW.world()).window.setZoomout(0);
/* 115 */       (VIEW.world()).window.centererTile.set(cx, cy + 3);
/* 116 */       show((VIEW.inters()).manager);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void mouseClick(MButt button) {
/* 121 */       if (button == MButt.LEFT) {
/* 122 */         this.s.click();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected void hoverTimer(GBox text) {
/* 128 */       this.s.hoverInfoGet((GUI_BOX)text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean render(Renderer r, float ds) {
/* 133 */       this.panel.render((SPRITE_RENDERER)r, ds);
/* 134 */       this.s.render((SPRITE_RENDERER)r, ds);
/* 135 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean update(float ds) {
/* 140 */       GAME.SPEED.tmpPause();
/* 141 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean canSave() {
/* 147 */       return this.canSave;
/*     */     }
/*     */ 
/*     */     
/*     */     public void exe() {
/* 152 */       hide();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\UIWBattlePrompt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */