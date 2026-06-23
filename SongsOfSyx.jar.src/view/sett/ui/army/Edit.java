/*     */ package view.sett.ui.army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.div.UIDivEditor;
/*     */ 
/*     */ final class Edit {
/*  29 */   private static CharSequence ¤¤title = "{0} divisions";
/*  30 */   private static CharSequence ¤¤Time = "¤The amount of days it will take to train this division to specification.";
/*     */   
/*     */   static {
/*  33 */     D.ts(Edit.class);
/*     */   }
/*     */   
/*  36 */   private final UIDivEditor editor = new UIDivEditor((STATS.BATTLE()).TRAINING_ALL.size(), true, false, true, RACES.all());
/*  37 */   private GuiSection section = new GuiSection();
/*  38 */   private final ArrayList<Div> all = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  39 */   private final INT.IntImp men = new INT.IntImp(0, (int)Math.ceil(((Config.battle()).MEN_PER_DIVISION / 10)));
/*     */   
/*     */   public int realMen() {
/*  42 */     return this.men.get() * 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Edit() {
/*  49 */     this.section.add((RENDEROBJ)this.editor);
/*     */ 
/*     */     
/*  52 */     GuiSection s = new GuiSection();
/*     */     
/*  54 */     GStat ss = new GStat()
/*     */       {
/*     */         
/*     */         public void update(GText text)
/*     */         {
/*  59 */           GFORMAT.i(text, (long)ti());
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/*  64 */           b.text(Edit.¤¤Time);
/*     */         }
/*     */ 
/*     */         
/*     */         double ti() {
/*  69 */           double am = ROOM_M_TRAINER.basicTrainingTimedays();
/*     */           
/*  71 */           for (StatsBattle.StatTraining t : (STATS.BATTLE()).TRAINING_ALL) {
/*  72 */             am += t.room.TRAINING_DAYS * Edit.this.editor.div().training(t) / t.room.bonus().get((BOOSTABLE_O)FACTIONS.player());
/*     */           }
/*     */           
/*  75 */           return am;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  81 */     s.addRightC(0, (RENDEROBJ)ss.hh((SPRITE)(SPRITES.icons()).m.time));
/*     */     
/*  83 */     s.addRightC(48, (RENDEROBJ)(new GButt.ButtPanel(Dic.¤¤Accept)
/*     */         {
/*     */ 
/*     */           
/*     */           protected void clickA()
/*     */           {
/*  89 */             for (Div d : Edit.this.all) {
/*  90 */               Edit.this.editor.copyChanges((DIV_SPEC.DIV_SPECE)d.info);
/*     */             }
/*     */             
/*  93 */             (VIEW.inters()).popup.close();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  98 */             activeSet(Edit.this.editor.hasChanges());
/*     */           }
/* 101 */         }).setDim(180, 32));
/* 102 */     s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(Dic.¤¤cancel)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 106 */             (VIEW.inters()).popup.close();
/*     */           }
/* 109 */         }).setDim(180, 32));
/*     */     
/* 111 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiSection get(LIST<Div> all, CLICKABLE trigger) {
/* 118 */     this.all.clearSloppy();
/* 119 */     this.all.add((Iterable)all);
/*     */     
/* 121 */     this.editor.div().copyFrom((DIV_SPEC)((Div)all.get(0)).info);
/* 122 */     if (all.size() > 1)
/* 123 */       this.editor.div().nameE().clear().add(¤¤title).insert(0, all.size()); 
/* 124 */     this.editor.clearChanges();
/*     */ 
/*     */     
/* 127 */     return this.section;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Edit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */