import { CommentArticle } from "./commentArticle.interface";

interface ICommentaireCreate {
    contenu: string,
    idArticle: number
}

export class CommentaireCreate implements ICommentaireCreate
{
    contenu!: string;
    idArticle!: number;

    constructor(commentaire: CommentArticle, articleId: number) {
        this.contenu = commentaire.contenu;
        this.idArticle = articleId;
    }
}

