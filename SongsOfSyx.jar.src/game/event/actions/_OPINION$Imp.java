/*     */ package game.event.actions;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.boosting.superb.SuperSpec;
/*     */ import game.event.engine.EChoice;
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Imp
/*     */   extends EventAction
/*     */ {
/*     */   private final SuperSpec.SuperSpecImp<Royalty> spec;
/*     */   
/*     */   Imp(String key, Event parent, EChoice choice, Json data, LISTE<EventAction> all) {
/*  46 */     super(key, all);
/*     */     
/*  48 */     BSourceInfo info = new BSourceInfo(parent.info.name, parent.info.icon);
/*  49 */     String desc = String.valueOf(info.name);
/*  50 */     if (choice != null) {
/*  51 */       desc = desc + " - " + desc + ". ";
/*     */     }
/*  53 */     double time = data.dTry("LENGHT_DAYS", 0.0D, 1000.0D, -1.0D);
/*  54 */     double value = data.d("VALUE", -1000.0D, 1000.0D);
/*  55 */     boolean isMul = data.bool("IS_MUL", false);
/*  56 */     double increase = data.dTry("INCREASE_PER_DAY", -100.0D, 100.0D, 0.0D);
/*  57 */     String k = "EVENT_" + key;
/*  58 */     if (increase < 0.0D) {
/*  59 */       this.spec = (SuperSpec.SuperSpecImp<Royalty>)new SuperSpec.Downer(-increase, ROPINION.BOOST(), k, info, desc, value, isMul, time);
/*  60 */     } else if (increase > 0.0D) {
/*  61 */       this.spec = (SuperSpec.SuperSpecImp<Royalty>)new SuperSpec.Uper(increase, time, ROPINION.BOOST(), k, info, desc, value, isMul);
/*  62 */     } else if (time > 0.0D) {
/*  63 */       this.spec = (SuperSpec.SuperSpecImp<Royalty>)new SuperSpec.TimeLimit(time, ROPINION.BOOST(), k, info, desc, value, isMul);
/*     */     } else {
/*  65 */       this.spec = (SuperSpec.SuperSpecImp<Royalty>)new SuperSpec.Permanent(ROPINION.BOOST(), k, info, desc, value, isMul);
/*     */     } 
/*  67 */     this.spec.hidden = true;
/*  68 */     data.checkUnused();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe(Event e, EContext data) {
/*  74 */     for (FactionNPC f : FACTIONS.NPCs()) {
/*  75 */       for (Royalty r : f.court().all()) {
/*  76 */         if (r.event()) {
/*  77 */           this.spec.activate((SuperBoostableObj)r, true);
/*     */         }
/*     */       } 
/*     */     } 
/*  81 */     super.exe(e, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox b, Event event, EContext context) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToMessageBody(LISTE<RENDEROBJ> rows, Event event, EContext context, RECTANGLE messBody) {
/*  93 */     final int am = context.royalty.am;
/*     */     
/*  95 */     rows.add((new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  99 */             GFORMAT.i(text, am);
/*     */           }
/* 101 */         }).hh(_OPINION.¤¤sTitle));
/*     */ 
/*     */ 
/*     */     
/* 105 */     rows.add((new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 109 */             if (_OPINION.Imp.this.spec.isMul) {
/* 110 */               text.add('*').s();
/* 111 */               GFORMAT.f1(text, _OPINION.Imp.this.spec.to());
/*     */             } else {
/* 113 */               GFORMAT.f0(text, _OPINION.Imp.this.spec.to());
/*     */             } 
/*     */           }
/* 116 */         }).hh((ROPINION.BOOST()).bo.name));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_OPINION$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */