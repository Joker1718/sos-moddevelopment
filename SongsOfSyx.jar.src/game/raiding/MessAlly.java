/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import view.ui.diplomacy.UIDipMess;
/*     */ import view.ui.message.MessageSection;
/*     */ import view.ui.message.MessageText;
/*     */ import world.region.RD;
/*     */ 
/*     */ class MessAlly
/*     */ {
/*  22 */   private static CharSequence ¤¤title = "Help!";
/*  23 */   private static CharSequence ¤¤desc = "If we don't pay this ransom, chances are neighbour allows for free passage through their lands, or gets attacked themselves.";
/*  24 */   private static CharSequence ¤¤destroy = "Raider destroys!";
/*     */   
/*  26 */   private static CharSequence ¤¤ftitle = "Raider Chased off";
/*  27 */   private static CharSequence ¤¤fdesc = "Due to your failure to pay off the raider, this faction is upset with you.";
/*     */   
/*  29 */   private static CharSequence ¤¤fwtitle = "Raider On their way";
/*  30 */   private static CharSequence ¤¤fwdesc = "Since we didn't pay our neighbour, they have now allowed for free passage for {0} into our lands. Muster the men!";
/*     */   
/*  32 */   private static CharSequence ¤¤requestHelp = "Request Assistance";
/*  33 */   private static CharSequence ¤¤requestHelpD = "Request that the faction attack this bandit. The consequences of this are hard to foresee.";
/*     */   static {
/*  35 */     D.ts(MessAlly.class);
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
/*     */   static void help(Raider r, FactionNPC f) {
/*  47 */     Str.TMP.clear();
/*  48 */     Str.TMP.add((CharSequence)(f.race()).info.raiderMess.allyHelp.rnd());
/*  49 */     RaiderText.insert.set(Str.TMP, r);
/*     */     
/*  51 */     (new Help((CharSequence)Str.TMP, f, new MessDemand.Demand(r))).send();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void fight(Raider r, FactionNPC f) {
/*  57 */     if ((r.army.power * (1.0F + RND.rFloat() * 2.0F)) > f.offensivePower() + (RD.MILITARY()).power.getD(f.capitolRegion())) {
/*  58 */       FACTIONS.remove(f, true);
/*  59 */       (new MessDestroy(r)).send();
/*     */     } else {
/*  61 */       Str.TMP.clear();
/*  62 */       Str.TMP.add((CharSequence)(f.race()).info.raiderMess.allyFight.rnd());
/*  63 */       RaiderText.insert.set(Str.TMP, r);
/*  64 */       ROPINION.GIFTS().makeDeal(f, -1.0D);
/*  65 */       (new Fight((CharSequence)Str.TMP, f)).send();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void letThrough(Raider r, FactionNPC f) {
/*  72 */     Str.TMP.clear();
/*  73 */     Str.TMP.add(¤¤fwdesc);
/*  74 */     Str.TMP.insert(0, r.name);
/*     */     
/*  76 */     (new MessageText(¤¤fwtitle, (CharSequence)Str.TMP)).send();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Help
/*     */     extends UIDipMess
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final MessDemand.Demand demand;
/*     */     
/*     */     private boolean requested = false;
/*     */     
/*     */     private Help(CharSequence message, FactionNPC f, MessDemand.Demand demand) {
/*  90 */       super(MessAlly.¤¤title, message, MessAlly.¤¤desc, f);
/*  91 */       this.demand = demand;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/*  96 */       super.make(section);
/*  97 */       section.addRelBody(8, DIR.S, this.demand.section(true));
/*  98 */       section.addRelBody(8, DIR.S, (RENDEROBJ)(new GButt.ButtPanel(MessAlly.¤¤requestHelp)
/*     */           {
/*     */             protected void renAction()
/*     */             {
/* 102 */               selectedSet(MessAlly.Help.this.requested);
/* 103 */               activeSet(MessAlly.Help.this.demand.canRespond());
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 108 */               if (!MessAlly.Help.this.requested && MessAlly.Help.this.demand.canRespond()) {
/* 109 */                 MessAlly.Help.this.requested = true;
/* 110 */                 (GAME.raiders()).current.setAllyFight();
/*     */               }
/*     */             
/*     */             }
/* 114 */           }).hoverInfoSet(MessAlly.¤¤requestHelpD));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Fight
/*     */     extends UIDipMess
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     private Fight(CharSequence message, FactionNPC f) {
/* 127 */       super(MessAlly.¤¤ftitle, message, MessAlly.¤¤fdesc, f);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class MessDestroy
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     private final Raider raider;
/*     */ 
/*     */     
/*     */     public MessDestroy(Raider raider) {
/* 143 */       super(MessAlly.¤¤destroy);
/* 144 */       this.raider = raider;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 150 */       Str.TMP.clear();
/* 151 */       Str.TMP.add((CharSequence)(this.raider.indu.race()).info.raiderMess.allyDead.rnd());
/* 152 */       RaiderText.insert.set(Str.TMP, this.raider);
/*     */       
/* 154 */       paragraph((CharSequence)Str.TMP);
/*     */       
/* 156 */       section.addRelBody(32, DIR.N, (SPRITE)(new RaiderPortrait(4)).set(this.raider));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessAlly.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */