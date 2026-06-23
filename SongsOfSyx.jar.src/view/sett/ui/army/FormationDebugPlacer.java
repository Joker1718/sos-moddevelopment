/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.tool.PlacableFixedImp;
/*     */ import view.ui.div.UIDivEditor;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class FormationDebugPlacer
/*     */   extends PlacableFixedImp
/*     */ {
/*     */   private static final int SIZES = 5;
/*     */   private final Army team;
/*  32 */   private final int[] widths = Alloc.ii(5);
/*  33 */   private final int[] height = Alloc.ii(5);
/*     */   private Div div;
/*  35 */   private final ArrayList<Div> divs = new ArrayList(1);
/*     */   private final LIST<CLICKABLE> butts;
/*  37 */   private final UIDivEditor editor = new UIDivEditor((STATS.BATTLE()).TRAINING_ALL.size(), true, true, false, RACES.all());
/*     */   
/*     */   public FormationDebugPlacer(Army team) {
/*  40 */     super((team == GAME.ARMIES().player()) ? "Place Division" : "Place Division Enemy", 1, 5);
/*  41 */     this.team = team;
/*     */     
/*  43 */     for (int i = 0; i < 5; i++) {
/*     */       
/*  45 */       double s = ((i + 1) * (Config.battle()).MEN_PER_DIVISION / 5);
/*  46 */       int w = (int)Math.ceil(Math.sqrt(s));
/*  47 */       int h = (int)Math.ceil(s / w);
/*  48 */       this.widths[i] = w;
/*  49 */       this.height[i] = h;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  54 */     this.butts = (LIST<CLICKABLE>)new ArrayList(this.editor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/*  63 */     return (SPRITE)(SPRITES.icons()).m.for_loose;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, int rx, int ry) {
/*  69 */     place(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void afterPlaced(int tx1, int ty1) {
/*  75 */     int x1 = tx1;
/*  76 */     int y1 = ty1;
/*  77 */     int x2 = x1 + width();
/*  78 */     x1 = x1 * 64 + 32;
/*  79 */     y1 = y1 * 64 + 32;
/*  80 */     x2 = x2 * 64 + 32;
/*  81 */     (GAME.ARMIES()).placer.deploy((LIST)this.divs, x1, x2, y1, y1);
/*     */     
/*  83 */     GAME.ARMIES().initAndTeleport((LIST)this.divs);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void place(int tx, int ty) {
/*  89 */     if (this.div.menNrOf() == 0) {
/*  90 */       this.div.info.copyFrom((DIV_SPEC)this.editor.div());
/*  91 */       this.div.settings().musteringSet(true);
/*  92 */       this.div.info.menSet(width() * height());
/*  93 */       this.divs.clear();
/*  94 */       this.divs.add(this.div);
/*     */     } 
/*     */     
/*  97 */     if (this.div.menNrOf() < (Config.battle()).MEN_PER_DIVISION) {
/*  98 */       HTYPE t = (this.team != GAME.ARMIES().player()) ? HTYPES.ENEMY() : HTYPES.SUBJECT();
/*  99 */       Humanoid h = new Humanoid(tx * 64 + 32, ty * 64 + 32, this.editor.div().race(), t, null);
/* 100 */       for (StatsBattle.StatTraining tr : (STATS.BATTLE()).TRAINING_ALL) {
/* 101 */         tr.stat.indu().setD(h.indu(), this.editor.div().training(tr));
/*     */       }
/*     */       
/* 104 */       for (EquipBattle b : STATS.EQUIP().BATTLE_ALL()) {
/* 105 */         b.stat().indu().setD(h.indu(), this.editor.div().equip(b));
/*     */       }
/*     */       
/* 108 */       (STATS.BATTLE()).COMBAT_EXPERIENCE.indu().setD(h.indu(), this.editor.div().experience());
/*     */       
/* 110 */       (STATS.BATTLE()).basicTraining.setD(h.indu(), 1.0D);
/* 111 */       this.div.info.menSet((Config.battle()).MEN_PER_DIVISION);
/* 112 */       h.setDivision(this.div);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean setDiv() {
/* 119 */     this.div = this.team.getNextEmptyOrdered();
/* 120 */     if (this.div != null) {
/* 121 */       return true;
/*     */     }
/* 123 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placableWhole(int tx1, int ty1) {
/* 128 */     if (!setDiv())
/* 129 */       return E; 
/* 130 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 135 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/* 136 */       return E;
/*     */     }
/* 138 */     if ((SETT.PATH()).solidity.is(tx, ty)) {
/* 139 */       return E;
/*     */     }
/* 141 */     if (SETT.ENTITIES().hasAtTile(tx, ty)) {
/* 142 */       return E;
/*     */     }
/* 144 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int width() {
/* 150 */     return this.widths[size()];
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 155 */     return this.height[size()];
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 160 */     return this.butts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\FormationDebugPlacer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */