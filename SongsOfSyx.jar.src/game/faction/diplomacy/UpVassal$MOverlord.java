/*     */ package game.faction.diplomacy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.FWorth;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import java.util.Arrays;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
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
/*     */ class MOverlord
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int[] creds;
/*     */   private final int[] fi;
/*     */   private final int[] fii;
/*     */   private final boolean[] aa;
/*     */   private boolean accepted = false;
/* 145 */   private final int day = TIME.days().bitsSinceStart();
/*     */   
/*     */   public MOverlord(LIST<? extends Faction> all) {
/* 148 */     super(UpVassal.¤¤tribute);
/*     */     
/* 150 */     this.fi = Alloc.ii(all.size());
/* 151 */     this.fii = Alloc.ii(all.size());
/* 152 */     this.creds = Alloc.ii(all.size());
/* 153 */     this.aa = new boolean[all.size()];
/* 154 */     Arrays.fill(this.aa, true);
/* 155 */     for (int i = 0; i < all.size(); i++) {
/* 156 */       FactionNPC f = (FactionNPC)all.get(i);
/* 157 */       this.fi[i] = f.index();
/* 158 */       this.fii[i] = f.iteration();
/* 159 */       DIP.TMP().setFactionAndClear(f);
/* 160 */       this.creds[i] = (int)FWorth.vassal((Faction)f);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/* 166 */     paragraph(UpVassal.¤¤overlord);
/*     */     
/* 168 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/* 170 */     for (int k = 0; k < this.creds.length; k++) {
/* 171 */       final int i = k;
/* 172 */       GuiSection row = new GuiSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 176 */             super.hoverInfoGet(text);
/* 177 */             if (!text.emptyIs()) {
/*     */               return;
/*     */             }
/* 180 */             FactionNPC f = UpVassal.MOverlord.this.f(i);
/* 181 */             if (f != null) {
/* 182 */               (VIEW.world()).UI.factions.hover(text, (Faction)f);
/*     */             }
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 188 */       SPRITE.Imp imp = new SPRITE.Imp(32)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 192 */             FactionNPC f = UpVassal.MOverlord.this.f(i);
/* 193 */             if (f != null) {
/* 194 */               (f.banner()).BIG.render(r, X1, Y1);
/*     */             }
/*     */           }
/*     */         };
/*     */       
/* 199 */       row.add((SPRITE)imp, 0, 0);
/*     */       
/* 201 */       row.addRightC(8, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 205 */               GFORMAT.iIncr(text, UpVassal.MOverlord.this.creds[i]);
/*     */             }
/*     */           });
/* 208 */       row.addRightC(160, (RENDEROBJ)(new GButt.Checkbox()
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 212 */               UpVassal.MOverlord.this.aa[i] = !UpVassal.MOverlord.this.aa[i];
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 217 */               selectedSet(UpVassal.MOverlord.this.aa[i]);
/* 218 */               activeSet(!UpVassal.MOverlord.this.accepted);
/*     */             }
/* 221 */           }).hoverInfoSet(Dic.¤¤Accept));
/*     */       
/* 223 */       row.pad(8, 4);
/*     */       
/* 225 */       rows.add(row);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 230 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows, ((RENDEROBJ)rows.get(0)).body().height() * 8)).view());
/*     */     
/* 232 */     section.addRelBody(16, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Accept)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 236 */             if (!UpVassal.MOverlord.this.accepted && TIME.days().bitsSinceStart() - UpVassal.MOverlord.this.day < 4) {
/* 237 */               UpVassal.MOverlord.this.accepted = true;
/* 238 */               for (int i = 0; i < UpVassal.MOverlord.this.creds.length; i++) {
/* 239 */                 if (UpVassal.MOverlord.this.f(i) != null) {
/* 240 */                   if (UpVassal.MOverlord.this.aa[i]) {
/* 241 */                     FACTIONS.player().credits().inc(UpVassal.MOverlord.this.creds[i], FCredits.CTYPE.TRIBUTE);
/* 242 */                     ROPINION.OTHER().acceptTribute(UpVassal.MOverlord.this.f(i), true);
/*     */                   } else {
/* 244 */                     ROPINION.OTHER().acceptTribute(UpVassal.MOverlord.this.f(i), false);
/*     */                   } 
/*     */                 }
/*     */               } 
/* 248 */               VIEW.messages().hide();
/*     */             } 
/*     */             
/* 251 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 256 */             selectedSet((UpVassal.MOverlord.this.accepted && Math.abs(UpVassal.MOverlord.this.day - TIME.days().bitsSinceStart()) < 4));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private FactionNPC f(int i) {
/* 264 */     FactionNPC f = (FactionNPC)FACTIONS.getByIndex(this.fi[i]);
/* 265 */     if (f != null && f.isActive() && f.iteration() == this.fii[i] && DIP.overlord((Faction)f) == FACTIONS.player()) {
/* 266 */       return f;
/*     */     }
/* 268 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\UpVassal$MOverlord.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */