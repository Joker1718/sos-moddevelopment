/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.diplomacy.deal.DealSave;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ public final class UIDipMessDeal extends MessageSection {
/*  27 */   static CharSequence ¤¤noLonger = "¤This offer is no longer valid.";
/*  28 */   static CharSequence ¤¤accepted = "¤You have accepted this offer.";
/*  29 */   static CharSequence ¤¤declined = "¤You have declined this offer.";
/*  30 */   static CharSequence ¤¤Time = "¤Inform us of your decision within a day.";
/*     */   
/*  32 */   static CharSequence ¤¤AcceptD = "¤Accepting this offer will change the faction's opinion of you by:";
/*  33 */   static CharSequence ¤¤DeclineD = "¤Declining this offer will change the faction's opinion of you by:";
/*     */   
/*  35 */   private static CharSequence ¤¤Exp = "The agreement has expired.";
/*  36 */   private static CharSequence ¤¤Power = "Since this agreement was drafted too much has changed.";
/*     */   
/*  38 */   private static CharSequence ¤¤Inspect = "¤Inspect Faction.";
/*     */   
/*     */   static {
/*  41 */     D.ts(UIDipMessDeal.class);
/*     */   }
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final double powerF;
/*     */   private final double powerP;
/*     */   private final boolean peace;
/*     */   private final double time;
/*     */   private final DealSave save;
/*     */   private final String message;
/*     */   private final String desc;
/*  51 */   private byte aa = 0;
/*     */   private final double happiness;
/*     */   private final double decline;
/*     */   private final UIDipMess.MessIntro intro;
/*     */   
/*     */   public UIDipMessDeal(CharSequence title, CharSequence message, CharSequence desc, Deal deal, double happiness, double declineP) {
/*  57 */     super(title);
/*  58 */     this.peace = deal.bools.PEACE.is();
/*  59 */     this.powerF = deal.npc.npc().offensivePower();
/*  60 */     this.powerP = FACTIONS.player().offensivePower();
/*  61 */     this.time = TIME.currentSecond();
/*  62 */     this.save = new DealSave(deal);
/*  63 */     this.message = String.valueOf(message);
/*  64 */     this.desc = (desc == null) ? null : String.valueOf(desc);
/*  65 */     this.happiness = happiness;
/*  66 */     this.decline = declineP;
/*  67 */     (deal.npc.npc()).request.set(declineP, title);
/*  68 */     this.intro = new UIDipMess.MessIntro(deal.npc.npc());
/*     */   }
/*     */   
/*     */   public UIDipMessDeal(CharSequence title, CharSequence desc, Deal deal, double happiness, double declineP) {
/*  72 */     this(title, desc, null, deal, happiness, declineP);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/*  80 */     paragraph(this.message);
/*     */     
/*  82 */     section.addRelBody(16, DIR.S, (RENDEROBJ)new UIDealListSaved(this.save, 250));
/*     */ 
/*     */ 
/*     */     
/*  86 */     section.addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  90 */             CharSequence pa = UIDipMessDeal.this.pactive();
/*  91 */             if (pa != null) {
/*  92 */               text.warnify();
/*  93 */               text.add(pa);
/*  94 */               text.setMaxWidth(900);
/*     */             } else {
/*  96 */               text.color(COLOR.WHITE85);
/*  97 */               text.add(UIDipMessDeal.¤¤Time);
/*     */             }
/*     */           
/*     */           }
/* 101 */         }).r(DIR.N));
/*     */     
/* 103 */     GuiSection s = new GuiSection();
/* 104 */     s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/* 108 */             activeSet((UIDipMessDeal.this.save.f() != null));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 113 */             (VIEW.world()).UI.factions.open(UIDipMessDeal.this.save.f());
/*     */           }
/* 116 */         }).hoverTitleSet(¤¤Inspect));
/* 117 */     s.addRightC(0, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Accept)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/* 121 */             activeSet((UIDipMessDeal.this.pactive() == null));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 126 */             Deal d = DIP.TMP();
/* 127 */             if (UIDipMessDeal.this.pactive() != null) {
/*     */               return;
/*     */             }
/* 130 */             d.execute(false);
/* 131 */             (UIDipMessDeal.this.save.f()).request.clear();
/* 132 */             ROPINION.GIFTS().makeDeal(d.npc.npc(), UIDipMessDeal.this.happiness);
/* 133 */             UIDipMessDeal.this.aa = 1;
/* 134 */             VIEW.messages().hide();
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 139 */             GBox b = (GBox)text;
/* 140 */             b.text(UIDipMessDeal.¤¤AcceptD);
/* 141 */             b.NL();
/* 142 */             b.add((SPRITE)GFORMAT.f0(b.text(), UIDipMessDeal.this.happiness));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 147 */     s.addRightC(0, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Decline)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/* 151 */             boolean a = true;
/* 152 */             if (UIDipMessDeal.this.aa == 1)
/* 153 */               a = false; 
/* 154 */             if (UIDipMessDeal.this.aa == -1)
/* 155 */               a = false; 
/* 156 */             if (Math.abs(TIME.currentSecond() - UIDipMessDeal.this.time) > TIME.secondsPerDay())
/* 157 */               a = false; 
/* 158 */             if (UIDipMessDeal.this.save.f() == null)
/* 159 */               a = false; 
/* 160 */             activeSet(a);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 165 */             UIDipMessDeal.this.aa = -1;
/* 166 */             (UIDipMessDeal.this.save.f()).request.expire();
/* 167 */             VIEW.messages().hide();
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 172 */             GBox b = (GBox)text;
/* 173 */             b.text(UIDipMessDeal.¤¤DeclineD);
/* 174 */             b.NL();
/* 175 */             b.add((SPRITE)GFORMAT.f0(b.text(), UIDipMessDeal.this.decline));
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 181 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */     
/* 184 */     section.addRelBody(8, DIR.N, (RENDEROBJ)this.intro.make());
/*     */ 
/*     */     
/* 187 */     if (this.desc != null) {
/* 188 */       section.addRelBody(8, DIR.S, (SPRITE)(new GText((UI.FONT()).M, this.desc)).lablifySub().setMaxWidth(900));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CharSequence pactive() {
/* 196 */     if (this.aa == 1)
/* 197 */       return ¤¤accepted; 
/* 198 */     if (this.aa == -1)
/* 199 */       return ¤¤declined; 
/* 200 */     if (Math.abs(TIME.currentSecond() - this.time) > TIME.secondsPerDay())
/* 201 */       return ¤¤Exp; 
/* 202 */     CharSequence p = this.save.set(DIP.TMP());
/* 203 */     if (p != null) {
/* 204 */       return p;
/*     */     }
/* 206 */     if (this.peace) {
/* 207 */       if (Math.abs((this.powerF + 10000.0D) / (this.save.f().offensivePower() + 10000.0D) - 1.0D) > 0.25D) {
/* 208 */         return ¤¤Power;
/*     */       }
/*     */       
/* 211 */       if (Math.abs((this.powerP + 10000.0D) / (FACTIONS.player().offensivePower() + 10000.0D) - 1.0D) > 0.25D) {
/* 212 */         return ¤¤Power;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 217 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDipMessDeal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */