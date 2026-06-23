/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.faction.npc.FactionNPC;
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
/*     */ import util.text.Dic;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ public abstract class UIDipMessAction
/*     */   extends MessageSection {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final double time;
/*     */   private final String desc;
/*     */   private final String req;
/*     */   private boolean accepted;
/*     */   private byte aa;
/*     */   private final double declinePenalty;
/*     */   private final double happiness;
/*     */   private final UIDipMess.MessIntro intro;
/*     */   private final UIDipMess.MessFaction of;
/*     */   
/*     */   public UIDipMessAction(CharSequence title, CharSequence desc, CharSequence req, FactionNPC f, FactionNPC o, double happiness, double decline) {
/*  35 */     super(title);
/*  36 */     this.time = TIME.currentSecond();
/*  37 */     this.desc = String.valueOf(desc);
/*  38 */     this.req = String.valueOf(req);
/*  39 */     this.of = new UIDipMess.MessFaction(o);
/*  40 */     this.declinePenalty = decline;
/*  41 */     this.happiness = happiness;
/*  42 */     f.request.set(decline, title);
/*  43 */     this.intro = new UIDipMess.MessIntro(f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/*  50 */     paragraph(this.desc);
/*     */     
/*  52 */     section.addRelBody(8, DIR.S, (SPRITE)(new GText((UI.FONT()).M, this.req)).lablifySub().setMaxWidth(900));
/*     */     
/*  54 */     section.addRelBody(8, DIR.S, (SPRITE)(new GText((UI.FONT()).S, UIDipMessDeal.¤¤Time)).color(COLOR.WHITE85).setMaxWidth(900));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     GuiSection s = new GuiSection();
/*  60 */     s.addRightC(0, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Accept)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/*  64 */             activeSet(UIDipMessAction.this.pactive());
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/*  69 */             UIDipMessAction.this.accepted = true;
/*  70 */             ROPINION.GIFTS().makeDeal(UIDipMessAction.this.intro.faction(), UIDipMessAction.this.happiness);
/*  71 */             UIDipMessAction.this.accept(UIDipMessAction.this.intro.faction(), UIDipMessAction.this.of.faction());
/*  72 */             UIDipMessAction.this.close();
/*  73 */             UIDipMessAction.this.aa = 1;
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  78 */             GBox b = (GBox)text;
/*  79 */             b.text(UIDipMessDeal.¤¤AcceptD);
/*  80 */             b.NL();
/*  81 */             b.add((SPRITE)GFORMAT.f0(b.text(), UIDipMessAction.this.happiness));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  86 */     s.addRightC(0, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Decline)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/*  90 */             boolean a = true;
/*  91 */             if (UIDipMessAction.this.accepted)
/*  92 */               a = false; 
/*  93 */             if (Math.abs(TIME.currentSecond() - UIDipMessAction.this.time) > TIME.secondsPerDay())
/*  94 */               a = false; 
/*  95 */             if (UIDipMessAction.this.intro.faction() == null || UIDipMessAction.this.of.faction() == null)
/*  96 */               a = false; 
/*  97 */             activeSet(a);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 102 */             UIDipMessAction.this.accepted = true;
/* 103 */             (UIDipMessAction.this.intro.faction()).request.expire();
/* 104 */             UIDipMessAction.this.close();
/* 105 */             UIDipMessAction.this.aa = -1;
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 110 */             GBox b = (GBox)text;
/* 111 */             b.text(UIDipMessDeal.¤¤DeclineD);
/* 112 */             b.NL();
/* 113 */             b.add((SPRITE)GFORMAT.f0(b.text(), UIDipMessAction.this.declinePenalty));
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 119 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */     
/* 121 */     section.addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 125 */             if (!UIDipMessAction.this.pactive()) {
/* 126 */               text.warnify();
/* 127 */               if (UIDipMessAction.this.aa == -1) {
/* 128 */                 text.add(UIDipMessDeal.¤¤declined);
/* 129 */               } else if (UIDipMessAction.this.aa == 1) {
/* 130 */                 text.add(UIDipMessDeal.¤¤accepted);
/*     */               } else {
/* 132 */                 text.add(UIDipMessDeal.¤¤noLonger);
/* 133 */               }  text.setMaxWidth(900);
/*     */             }
/*     */           
/*     */           }
/* 137 */         }).r(DIR.N));
/*     */     
/* 139 */     section.addRelBody(8, DIR.N, (RENDEROBJ)this.intro.make());
/*     */   }
/*     */   
/*     */   private boolean pactive() {
/* 143 */     if (this.accepted)
/* 144 */       return false; 
/* 145 */     if (Math.abs(TIME.currentSecond() - this.time) > TIME.secondsPerDay())
/* 146 */       return false; 
/* 147 */     if (this.intro.faction() == null || this.of.faction() == null)
/* 148 */       return false; 
/* 149 */     return valid(this.intro.faction(), this.of.faction());
/*     */   }
/*     */   
/*     */   protected abstract void accept(FactionNPC paramFactionNPC1, FactionNPC paramFactionNPC2);
/*     */   
/*     */   protected abstract boolean valid(FactionNPC paramFactionNPC1, FactionNPC paramFactionNPC2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDipMessAction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */