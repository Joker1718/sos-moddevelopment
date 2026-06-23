/*     */ package game.events.faction.player;
/*     */ 
/*     */ import game.events.EVENTS;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.Debugger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EventDiplomacy
/*     */   extends EVENTS.EventResource
/*     */ {
/*  22 */   private final double dTime = TIME.secondsPerDayI();
/*     */   private int ii;
/*  24 */   private double timer = 1.0D;
/*     */   
/*  26 */   private final War war = new War();
/*  27 */   private final Peace peace = new Peace();
/*  28 */   private final Stance stance = new Stance();
/*     */   
/*  30 */   private final EData[] datas = new EData[FACTIONS.MAX()];
/*     */   
/*     */   public EventDiplomacy() {
/*  33 */     super("DIPLOMACY");
/*  34 */     for (int i = 0; i < this.datas.length; i++) {
/*  35 */       this.datas[i] = new EData();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  71 */     this.timer -= ds * this.dTime * FACTIONS.NPCs().size();
/*  72 */     while (this.timer < 0.0D) {
/*  73 */       this.timer++;
/*  74 */       if (this.ii >= FACTIONS.NPCs().size()) {
/*  75 */         this.ii = 0;
/*  76 */         this.war.updateAll(TIME.secondsPerDay());
/*  77 */         this.peace.update();
/*     */       } 
/*  79 */       FactionNPC fa = (FactionNPC)FACTIONS.NPCs().get(this.ii);
/*  80 */       process(fa);
/*  81 */       this.ii++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void process(FactionNPC fa) {
/*  89 */     if (fa.request.has()) {
/*     */       return;
/*     */     }
/*     */     
/*  93 */     if (DIP.WAR().is(fa)) {
/*     */       return;
/*     */     }
/*     */     
/*  97 */     if (this.war.updateDay(fa)) {
/*     */       return;
/*     */     }
/*     */     
/* 101 */     EData data = this.datas[fa.index()];
/* 102 */     Induvidual king = (fa.court().king().roy()).induvidual;
/*     */     
/* 104 */     if (this.stance.process(fa, king, data)) {
/*     */       return;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 116 */     file.i(this.ii);
/* 117 */     file.d(this.timer);
/* 118 */     for (int i = 0; i < this.datas.length; i++) {
/* 119 */       this.datas[i].save(file);
/*     */     }
/* 121 */     this.war.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 126 */     this.ii = file.i();
/* 127 */     this.timer = file.d();
/* 128 */     for (int i = 0; i < this.datas.length; i++) {
/* 129 */       this.datas[i].load(file);
/*     */     }
/* 131 */     this.war.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 136 */     this.ii = 0;
/* 137 */     this.timer = 0.0D;
/* 138 */     for (int i = 0; i < this.datas.length; i++) {
/* 139 */       this.datas[i].clear();
/*     */     }
/* 141 */     this.war.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dismissWelcome(FactionNPC f) {
/* 146 */     (this.datas[f.index()]).welcomed = true;
/*     */   }
/*     */   static class EData implements SAVABLE { public boolean welcomed;
/*     */     
/*     */     EData() {
/* 151 */       this.welcomed = false;
/* 152 */       this.stanceMess = false;
/*     */     }
/*     */     public boolean stanceMess;
/*     */     public void save(FilePutter file) {
/* 156 */       file.bool(this.welcomed);
/* 157 */       file.bool(this.stanceMess);
/*     */     }
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 161 */       this.welcomed = file.bool();
/* 162 */       this.stanceMess = file.bool();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 167 */       this.welcomed = false;
/* 168 */       this.stanceMess = false;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Debugger d, FactionNPC npc) {
/* 174 */     d.title(getClass().getSimpleName());
/* 175 */     d.debug("timer").add(this.timer);
/* 176 */     d.debug("Faction Prev").add(this.ii).s().add((CharSequence)((FactionNPC)FACTIONS.NPCs().getC(this.ii)).name);
/* 177 */     d.debugObject("data", this.datas[npc.index()]);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\player\EventDiplomacy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */