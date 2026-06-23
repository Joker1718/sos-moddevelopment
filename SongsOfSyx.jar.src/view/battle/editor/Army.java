/*     */ package view.battle.editor;
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import view.ui.div.UIDivEditor;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ class Army extends GuiSection {
/*  24 */   static CharSequence ¤¤name = "armies"; private final GETTER.GETTER_IMP<ArmySide> current;
/*  25 */   private static CharSequence ¤¤generate = "Generate";
/*  26 */   private static CharSequence ¤¤add = "Add Unit";
/*     */   
/*     */   static {
/*  29 */     D.ts(Army.class);
/*     */   }
/*     */ 
/*     */   
/*     */   Army(final ArmySide player, final ArmySide enemy) {
/*  34 */     this.current = new GETTER.GETTER_IMP(player);
/*     */     
/*  36 */     FACTIONS.player().setRace((Race)RACES.playable().get(0));
/*  37 */     ((FactionNPC)FACTIONS.all().get(1)).generate((RDRace)(RD.RACES()).all.rnd(), false);
/*     */ 
/*     */     
/*  40 */     GuiSection s = new GuiSection();
/*  41 */     s.add((SPRITE)(UI.icons()).l.battle, 0, 0);
/*  42 */     s.addDownC(6, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.rotate)
/*     */         {
/*     */           
/*     */           protected void clickA()
/*     */           {
/*  47 */             (GAME.battle()).power.getClass(); double pow = 1000.0D + ((Config.battle()).MEN_PER_ARMY * RND.rFloat() * RND.rFloat() * RND.rFloat()) * 5.0D;
/*     */             
/*  49 */             player.generate(pow);
/*  50 */             enemy.generate(pow);
/*     */             
/*  52 */             super.clickA();
/*     */           }
/*  55 */         }).hoverInfoSet(¤¤generate));
/*     */     
/*  57 */     s.addRelBody(8, DIR.W, (RENDEROBJ)new ArmyFactionButt((Faction)FACTIONS.player(), player, (GETTER.GETTERE<ArmySide>)this.current));
/*  58 */     s.addRelBody(8, DIR.E, (RENDEROBJ)new ArmyFactionButt((Faction)FACTIONS.all().get(1), enemy, (GETTER.GETTERE<ArmySide>)this.current));
/*     */     
/*  60 */     addRelBody(8, DIR.S, (RENDEROBJ)s);
/*  61 */     addRelBody(8, DIR.S, UI.decor().borderTop(800));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  66 */     final UIDivEditor editor = new UIDivEditor((STATS.BATTLE()).TRAINING_ALL.size(), true, true, false, RACES.all());
/*  67 */     editor.div().raceSet((Race)RACES.playable().get(0));
/*     */     
/*  69 */     GuiSection guiSection1 = new GuiSection();
/*  70 */     guiSection1.add((RENDEROBJ)editor);
/*     */ 
/*     */     
/*  73 */     GuiSection butts = new GuiSection();
/*  74 */     butts.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(¤¤add)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  78 */             ((ArmySide)Army.this.current.get()).divs.add((new DIV_SPEC.DIV_SPECImp()).copyFrom((DIV_SPEC)editor.div()));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  83 */             activeSet(((ArmySide)Army.this.current.get()).divs.hasRoom());
/*     */           }
/*  86 */         }).pad(32, 0).repetativeSet(true));
/*  87 */     butts.addRightC(32, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.rotate)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  91 */             editor.div().generate();
/*     */           }
/*  94 */         }).hoverInfoSet(Dic.¤¤Generate));
/*     */     
/*  96 */     guiSection1.addRelBody(8, DIR.S, (RENDEROBJ)butts);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     guiSection1.addRelBody(8, DIR.W, (RENDEROBJ)new ArmyDivs(this.current, editor));
/* 103 */     addRelBody(8, DIR.S, (RENDEROBJ)guiSection1);
/*     */ 
/*     */     
/* 106 */     addRelBody(8, DIR.S, UI.decor().borderBottom(800));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\Army.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */