/*     */ package game.events.faction.player;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.diplomacy.deal.DealDrawfter;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.race.KingMessages;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.ui.diplomacy.UIDipMess;
/*     */ import view.ui.diplomacy.UIDipMessAction;
/*     */ import view.ui.diplomacy.UIDipMessDeal;
/*     */ import view.ui.message.MessageText;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ class WarMessages
/*     */ {
/*  22 */   private static CharSequence ¤¤War = "War!";
/*  23 */   private static CharSequence ¤¤WarD = "The enemy has shown itself. Let us muster and fight!";
/*     */   
/*     */   static void start(FactionNPC f) {
/*  26 */     KingMessages.Message m = ((f.king()).induvidual.race().kingMessage()).WAR_NORMAL;
/*  27 */     if (DIP.VASSAL().is(f)) {
/*  28 */       m = ((f.king()).induvidual.race().kingMessage()).WAR_VASSAL;
/*  29 */     } else if ((DIP.get(f)).ally) {
/*  30 */       m = ((f.king()).induvidual.race().kingMessage()).WAR_ALLY;
/*     */     } 
/*  32 */     (new UIDipMess(¤¤War, m.get(f), ¤¤WarD, f)).send();
/*     */   }
/*     */   
/*  35 */   private static CharSequence ¤¤Crusade = "More enemies";
/*  36 */   private static CharSequence ¤¤CrusadeD = "This faction joins our enemies.";
/*  37 */   private static CharSequence ¤¤CrusadeD2 = "This faction of {0} and {1} have now banded together against you. They call themselves: {1}.";
/*     */   static void join(FactionNPC f) {
/*     */     Str str;
/*  40 */     KingMessages.Message m = ((f.king()).induvidual.race().kingMessage()).WAR_JOIN_NORMAL;
/*  41 */     if (DIP.VASSAL().is(f)) {
/*  42 */       m = ((f.king()).induvidual.race().kingMessage()).WAR_JOIN_VASSAL;
/*  43 */     } else if ((DIP.get(f)).ally) {
/*  44 */       m = ((f.king()).induvidual.race().kingMessage()).WAR_JOIN_ALLY;
/*     */     } 
/*     */     
/*  47 */     CharSequence dd = ¤¤CrusadeD;
/*  48 */     if (DIP.WAR().all((Faction)FACTIONS.player()).size() == 2) {
/*  49 */       Str.TMP.clear().add(¤¤CrusadeD2).insert(0, (CharSequence)((Faction)DIP.WAR().all((Faction)FACTIONS.player()).get(0)).name).insert(1, (CharSequence)((Faction)DIP.WAR().all((Faction)FACTIONS.player()).get(1)).name).insert(2, (CharSequence)(DIP.WAR_PLAYER()).teamName);
/*  50 */       str = Str.TMP;
/*     */     } 
/*     */     
/*  53 */     (new UIDipMess(¤¤Crusade, m.get(f), (CharSequence)str, f)).send();
/*     */   }
/*     */   
/*  56 */   private static CharSequence ¤¤WarByProxy = "Proxy war!";
/*  57 */   private static CharSequence ¤¤WarByProxyD = "My lord, even in distant places they manage to hate our freedom and way of life. The distant faction {0} has aided our mortal enemy, {1}, bolstering their armies!";
/*     */   static void proxy(FactionNPC atWar, FactionNPC supplier, int am) {
/*  59 */     (new UIDipMess(¤¤WarByProxy, (CharSequence)Str.TMP.clear().add(¤¤WarByProxyD).insert(0, (CharSequence)supplier.name).insert(1, (CharSequence)atWar.name), null, atWar)).send();
/*     */   }
/*     */   
/*  62 */   private static CharSequence ¤¤rumour = "¤Bad Rumours";
/*  63 */   private static CharSequence ¤¤rumourD = "¤It has come to our attention that a rumour has been spread. That you {0}. Now, while those close to you know this isn't true, it has affected your standing amongst the other factions of Syx significantly. We do not know who started the rumours, but we suspect the ruler of {1} might have had something to do with it. On the bright side, we now have more international support should we choose to attack this faction.";
/*     */   static void poision(FactionNPC source) {
/*  65 */     (new MessageText(¤¤rumour)).paragraph((CharSequence)Str.TMP.clear().add(¤¤rumourD).insert(0, (CharSequence)(source.race().kingMessage()).RUMOUR.rnd()).insert(1, (CharSequence)source.name)).send();
/*     */   }
/*     */   
/*  68 */   private static CharSequence ¤¤terror = "¤Terrorists";
/*  69 */   private static CharSequence ¤¤terrorD = "¤In the region of {0} there has emerged an organization calling themselves {1}. These are violently opposing your rule and destabilizing the affiliation of the region. Apparently, they have received backing and funds from elsewhere, we suspect the ruler of {2}. On the bright side, we now have more international support should we choose to attack this faction.";
/*     */   static void ngo(FactionNPC source, Region target) {
/*  71 */     (new MessageText(¤¤terror)).paragraph((CharSequence)Str.TMP.clear().add(¤¤terrorD).insert(0, (CharSequence)target.info.name()).insert(1, (CharSequence)(source.race().kingMessage()).NGO.rnd()).insert(2, (CharSequence)source.name)).send();
/*     */   }
/*     */   
/*  74 */   static CharSequence ¤¤teachings = "¤Bad Teachings";
/*  75 */   private static CharSequence ¤¤teachingsD = "¤Someone has been spreading leaflets about the teachings of the Burnt Prophet, filling the heads of our subjects with ideas such as all are created equal, pacifism, self rule and other rubbish! As a result, our subjects loyalty will be diminished for some time. We do not know who is responsible to this, but the paper smells like it's from the faction on {0}. On the bright side, we now have more international support should we choose to attack this faction.";
/*     */   static void teachings(FactionNPC source) {
/*  77 */     (new MessageText(¤¤teachings)).paragraph((CharSequence)Str.TMP.clear().add(¤¤teachingsD).insert(0, (CharSequence)source.name)).send();
/*     */   }
/*     */   
/*  80 */   private static CharSequence ¤¤Demand = "Demand";
/*  81 */   private static CharSequence ¤¤DemandD = "Failure to comply with this request can have unforeseen consequences.";
/*     */   static void warn(FactionNPC f) {
/*  83 */     if (DIP.VASSAL().is(f)) {
/*  84 */       (new VassalRequest(f)).send();
/*     */     } else {
/*  86 */       Deal d = DIP.TMP();
/*  87 */       d.setFactionAndClear(f);
/*  88 */       DealDrawfter.draft(d, -d.player.selfWorth() * (0.2D + RND.rFloat() * 0.2D), true, true);
/*     */       
/*  90 */       if (d.hasDeal()) {
/*  91 */         KingMessages.Message m = ((f.king()).induvidual.race().kingMessage()).THREAT_NORMAL;
/*  92 */         if ((DIP.get(f)).transit) {
/*  93 */           m = ((f.king()).induvidual.race().kingMessage()).THREAT_ALLY;
/*     */         }
/*  95 */         double v = ROPINION.GIFTS().getGenerosityNeededForPeace(f);
/*  96 */         (new UIDipMessDeal(¤¤Demand, m.get(f), ¤¤DemandD, d, v, -0.5D)).send();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/* 101 */   private static CharSequence ¤¤breakTitle = "¤Freedom request";
/* 102 */   private static CharSequence ¤¤breakBody = "¤This faction asks that you release them from their bounds. The faction will become your colleague, and the faction will be very grateful should you accept. Decline and they might get bad ideas.";
/*     */ 
/*     */   
/*     */   private static class VassalRequest
/*     */     extends UIDipMessAction
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public VassalRequest(FactionNPC f) {
/* 111 */       super(WarMessages.¤¤breakTitle, ((f.king()).induvidual.race().kingMessage()).THREAT_VASSAL.get(f), WarMessages.¤¤breakBody, f, f, 1.0D, -1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void accept(FactionNPC f, FactionNPC o) {
/* 116 */       DIP.PACT().set(f);
/* 117 */       ROPINION.OTHER().liberate(f);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean valid(FactionNPC f, FactionNPC o) {
/* 122 */       return DIP.VASSAL().is(f);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 129 */     D.ts(WarMessages.class);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\player\WarMessages.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */